package com.deadlock.aiehbarril.model.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deadlock.aiehbarril.model.Rating;

/*OBS.: não foi testado*/

public class RatingSQLite extends SQLiteBase {

	public RatingSQLite(){
		open();
		try{

			PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Ratings ("+
					"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
					"ponctuality INTEGER,"+
					"explanation INTEGER,"+
					"exam_correction INTEGER,"+
					"exam_second INTEGER,"+
					"requires_presence INTEGER,"+
					"confidence INTEGER,"+
					"exam_by_lectures INTEGER,"+
					"exams_content INTEGER,"+
					"projects INTEGER,"+
					"eh_barril NUMERIC,"+
					"fk_courseID INTEGER, "+
					"FOREIGN KEY(fk_courseID) REFERENCES Courses(id));");
			stm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void create(Rating c){//usefull
		open();
		try{
			PreparedStatement stm = conn.prepareStatement("INSERT INTO Ratings VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
			stm.setInt(2, c.getPonctuality());
			stm.setInt(3, c.getExplanation());
			stm.setInt(4, c.getExam_correction());
			stm.setInt(5, c.getExam_second());
			stm.setInt(6, c.getRequires_presence());
			stm.setInt(7, c.getConfidence());
			stm.setInt(8, c.getExam_by_lectures());
			stm.setInt(9, c.getExams_content());
			stm.setInt(10, c.getProjects());
			stm.setShort(11, c.isEh_barril());
			stm.setInt(12, c.getCourseID());

			stm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<Rating> all(){
		ArrayList<Rating> result = new ArrayList<>();
		open();
		try{
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM Ratings ORDER BY id ASC;");

			ResultSet rs = stm.executeQuery();

			while(rs.next()){
				Rating c = new Rating(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getShort(11),
						rs.getInt(12)
						);
				result.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public void update(Rating c){
		conn = open();

		try{

			PreparedStatement stm = conn.prepareStatement("UPDATE Ratings SET "+
					"explanation = ?, "+
					"requires_presence = ?, "+
					"exam_dificulty = ?, "+
					"free_to_answers = ?, "+
					"projects = ?, "+
					"confidence = ?, "+
					"eh_barril = ?, "+
					"fk_courseID = ? "+
					"WHERE id = ?;");

			stm.setInt(1, c.getPonctuality());
			stm.setInt(2, c.getExplanation());
			stm.setInt(3, c.getExam_correction());
			stm.setInt(4, c.getExam_second());
			stm.setInt(5, c.getRequires_presence());
			stm.setInt(6, c.getConfidence());
			stm.setInt(7, c.getExam_by_lectures());
			stm.setInt(8, c.getExams_content());
			stm.setInt(9, c.getProjects());
			stm.setShort(10, c.isEh_barril());
			stm.setInt(11, c.getCourseID());
			stm.setInt(12, c.getId());

			stm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void delete(Rating c){
		conn = open();

		try{

			PreparedStatement stm = conn.prepareStatement("DELETE FROM Ratings WHERE id = ?;");

			stm.setInt(1, c.getId());

			stm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Rating find(int PK){
		Rating result = null;
		conn = open();
		try{
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM Ratings WHERE id = ?;");

			stm.setInt(1, PK);
			ResultSet rs = stm.executeQuery();

			if(rs.next()){
				Rating c = new Rating(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getShort(11),
						rs.getInt(12)
						);
				result = c;
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public List<Rating> whereCourse(int FK){//usefull
		ArrayList<Rating> result = new ArrayList<>();
		conn = open();
		try{
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM Ratings WHERE fk_courseID = ?;");

			stm.setInt(1, FK);
			ResultSet rs = stm.executeQuery();

			while(rs.next()){
				Rating c = new Rating(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getShort(11),
						rs.getInt(12)
						);
				result.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

}
