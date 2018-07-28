package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;
import com.deadlock.aiehbarril.model.Rating;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressBar;

public class CourseProfileController implements Initializable {

	Course selectedCourse = null;

	  @FXML
	  private Label lbl_media_explanation;

	  @FXML
	  private Label lbl_porcentagemEhBarril;

	  @FXML
	  private Label lbl_media_exam_by_lectures_text;

	  @FXML
	  private Label lbl_headAlias;

	  @FXML
	  private Label lbl_numVotos;

	  @FXML
	  private Label lbl_media_projects_text;

	  @FXML
	  private Label lbl_media_ponctuality;

	  @FXML
	  private Label lbl_media_ponctuality_text;

	  @FXML
	  private Label lbl_media_exam_second;

	  @FXML
	  private Label lbl_media_confidence;

	  @FXML
	  private Label lbl_media_projects;

	  @FXML
	  private Label lbl_media_explanation_text;

	  @FXML
	  private Label lbl_media_confidence_text;

	  @FXML
	  private Label lbl_media_exam_second_text;

	  @FXML
	  private Label lbl_media_exam_content;

	  @FXML
	  private Label lbl_media_exam_content_text;

	  @FXML
	  private Label lbl_media_exam_by_lectures;

	  @FXML
	  private Label lbl_media_requires_presence;

	  @FXML
	  private Label lbl_media_examCorrection;

	  @FXML
	  private Label lbl_media_requires_presence_text;

	  @FXML
	  private Label lbl_headProfessor;

	  @FXML
	  private Label lbl_media_examCorrection_text;
	    
	@FXML
	private MenuButton dropMenu;
	
	@FXML
	private ProgressBar barra;
	
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				if (newScreen.equals("view/CourseProfile.fxml")) {
					if (userData != null) {
						selectedCourse = (Course) userData;
						Rating m = Rating.mediaRating(selectedCourse);
						int num = Rating.whereCourse(selectedCourse.getId()).size();
						lbl_headAlias.setText(selectedCourse.getAlias());
						lbl_headProfessor.setText(selectedCourse.getProfessor());
						lbl_media_ponctuality.setText(Integer.toString(m.getPonctuality()));
						lbl_media_explanation.setText(Integer.toString(m.getExplanation()));
						lbl_media_examCorrection.setText(Integer.toString(m.getExam_correction()));
						lbl_media_exam_second.setText(Integer.toString(m.getExam_second()));
						lbl_media_requires_presence.setText(Integer.toString(m.getRequires_presence()));
						lbl_media_confidence.setText(Integer.toString(m.getConfidence()));
						lbl_media_exam_by_lectures.setText(Integer.toString(m.getExam_by_lectures()));
						lbl_media_exam_content.setText(Integer.toString(m.getExams_content()));
						lbl_media_projects.setText(Integer.toString(m.getProjects()));
						lbl_numVotos.setText(num+" Votos");
						
						barra.setProgress(m.isEh_barril()/50);
						
					}
					System.out.print(selectedCourse);

				}
			}
		});

	}

	@FXML
	private void handleEvaluate(ActionEvent event) {
		System.out.print("Evaluate\n");
		Main.changeScreen("view/RateCourse.fxml",selectedCourse);
	}

	@FXML
	private void handleSearchCourse(ActionEvent event) {
		System.out.print("SearchCourse\n");
		Main.changeScreen("view/SearchCourse.fxml");
	}
	
	@FXML
	private void handleRegisterCourse(ActionEvent event) {
		System.out.print("SearchCourse\n");
		Main.changeScreen("view/RegisterCourse.fxml");
	}
}
