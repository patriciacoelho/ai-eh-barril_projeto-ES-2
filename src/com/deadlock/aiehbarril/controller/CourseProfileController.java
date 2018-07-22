package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CourseProfileController implements Initializable {

	Course selectedCourse = null;
	@FXML
	private Label profile_alias;
	@FXML
	private Label profile_professor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				// TODO Auto-generated method stub
				if(newScreen.equals("view/CourseProfile.fxml")){
					if(userData != null){
						selectedCourse = (Course) userData;
						profile_alias.setText(selectedCourse.getAlias());
						profile_professor.setText(selectedCourse.getProfessor());
					}
					System.out.print(selectedCourse);
				}
			}
		});

	}

	@FXML
	private void handleEvaluate(ActionEvent event) {
		System.out.print("Evaluate\n");
		Main.changeScreen("view/Evaluate.fxml");
	}

	@FXML
	private void handleSearchCourse(ActionEvent event) {
		System.out.print("SearchCourse\n");
		Main.changeScreen("view/SearchCourse.fxml");
	}

}
