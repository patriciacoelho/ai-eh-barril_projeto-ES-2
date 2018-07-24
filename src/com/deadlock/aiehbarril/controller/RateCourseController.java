package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class RateCourseController implements Initializable {

	Course selectedCourse = null;
	@FXML
    private Label headAlias;

    @FXML
    private Label headProfessor;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				if (newScreen.equals("view/RateCourse.fxml")) {
					if (userData != null) {
						selectedCourse = (Course) userData;
						headAlias.setText(selectedCourse.getAlias()); // TÁ DANDO ERRO AQUI
						headProfessor.setText(selectedCourse.getProfessor());
						System.out.print("cabecalho");
					}
					//System.out.print(selectedCourse);

				}
			}
		});

	}

	@FXML
	private void handleCourseProfile(ActionEvent event) {
		System.out.print("CourseProfile\n");
		Main.changeScreen("view/CourseProfile.fxml");
	}

	@FXML
	private void handleLastStepRating(ActionEvent event) {
		System.out.print("LastStepRating\n");
		Main.changeScreen("view/LastStepRating.fxml");
	}

	@FXML
	private void handleRatingFeedback(ActionEvent event) {
		System.out.print("RatingFeedback\n");
		Main.changeScreen("view/RatingFeedback.fxml");
	}

	@FXML
	private void handleEvaluate(ActionEvent event) {
		System.out.print("Evaluate\n");
		Main.changeScreen("view/RateCourse.fxml");
	}

	@FXML
	private void handleSearchCourse(ActionEvent event) {
		System.out.print("SearchCourse\n");
		Main.changeScreen("view/SearchCourse.fxml");
	}

}
