package com.deadlock.aiehbarril.model;

import java.util.List;

import com.deadlock.aiehbarril.model.sqlite.RatingSQLite;

public class Rating {
	private int _id;
	private Integer id = new Integer(_id);

	private int ponctuality;
	private int explanation;
	private int exam_correction;
	private int exam_second;
	private int requires_presence;
	private int confidence;
	private int exam_by_lectures;
	private int exams_content;
	private int projects;
	private short eh_barril;

	private int fk_courseID;


	public Rating() {
		this.explanation = 0;
		this.requires_presence = 0;
		this.exam_second = 0;
		this.ponctuality = 0;
		this.projects = 0;
		this.confidence = 0;
		this.eh_barril = 0;
		this.exam_correction = 0;
		this.exam_by_lectures = 0;
		this.exams_content = 0;
	}


	public Rating(int ponctuality, int explanation, int exam_correction, int exam_second,
			int requires_presence, int confidence, int exam_by_lectures, int exams_content, int projects,
			short eh_barril, int fk_courseID) {
		this.ponctuality = ponctuality;
		this.explanation = explanation;
		this.exam_correction = exam_correction;
		this.exam_second = exam_second;
		this.requires_presence = requires_presence;
		this.confidence = confidence;
		this.exam_by_lectures = exam_by_lectures;
		this.exams_content = exams_content;
		this.projects = projects;
		this.eh_barril = eh_barril;
		this.fk_courseID = fk_courseID;
	}

	public Rating(int _id, int ponctuality, int explanation, int exam_correction, int exam_second,
			int requires_presence, int confidence, int exam_by_lectures, int exams_content, int projects,
			short eh_barril, int fk_courseID) {
		this._id = _id;
		this.ponctuality = ponctuality;
		this.explanation = explanation;
		this.exam_correction = exam_correction;
		this.exam_second = exam_second;
		this.requires_presence = requires_presence;
		this.confidence = confidence;
		this.exam_by_lectures = exam_by_lectures;
		this.exams_content = exams_content;
		this.projects = projects;
		this.eh_barril = eh_barril;
		this.fk_courseID = fk_courseID;
	}

	public int getPonctuality() {
		return ponctuality;
	}

	public void setPonctuality(int ponctuality) {
		this.ponctuality = ponctuality;
	}

	public int getExplanation() {
		return explanation;
	}

	public void setExplanation(int explanation) {
		this.explanation = explanation;
	}

	public int getExam_correction() {
		return exam_correction;
	}

	public void setExam_correction(int exam_correction) {
		this.exam_correction = exam_correction;
	}

	public int getExam_second() {
		return exam_second;
	}

	public void setExam_second(int exam_second) {
		this.exam_second = exam_second;
	}

	public int getRequires_presence() {
		return requires_presence;
	}

	public void setRequires_presence(int requires_presence) {
		this.requires_presence = requires_presence;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public int getExam_by_lectures() {
		return exam_by_lectures;
	}

	public void setExam_by_lectures(int exam_by_lectures) {
		this.exam_by_lectures = exam_by_lectures;
	}

	public int getExams_content() {
		return exams_content;
	}

	public void setExams_content(int exams_content) {
		this.exams_content = exams_content;
	}

	public int getProjects() {
		return projects;
	}

	public void setProjects(int projects) {
		this.projects = projects;
	}

	public short isEh_barril() {
		return eh_barril;
	}
	public void setEh_barril(short eh_barril) {
		this.eh_barril = eh_barril;
	}

	public int getId() {
		return _id;
	}

	public int getCourseID() {
		return fk_courseID;
	}

	public void setCourseID(int courseID) {
		this.fk_courseID = courseID;
	}

	public String toString(){
    	return "id:"+ _id+"| eh_barril? "+ eh_barril +" |"+"| CourseID? "+ fk_courseID +" |"+ponctuality+", "+explanation+", "+exam_correction+", "+exam_second+", "+
    			requires_presence+", "+confidence+", "+exam_by_lectures+", "+exams_content+", "+projects+" |\n";
    }

	/** ____________DAO______________*/
	private static RatingSQLite dao = new RatingSQLite();
	public void save(){
		if(id != null && dao.find(_id) != null)
			dao.update(this);
		else
			dao.create(this);
	}

	public void delete(){
		if(dao.find(_id) != null)
			dao.delete(this);
	}

	public static List<Rating> all(){
		return dao.all();
	}

	public static Rating find(int pk){
		return dao.find(pk);
	}

	public static List<Rating> whereCourse(int FK){
		return dao.whereCourse(FK);
	}

}
