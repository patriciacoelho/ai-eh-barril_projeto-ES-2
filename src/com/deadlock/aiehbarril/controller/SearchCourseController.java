package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SearchCourseController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void handleAbout(ActionEvent event) {
		System.out.print("About\n");
		Main.changeScreen("view/About.fxml");
	}

	@FXML
	private void handleCourseProfile(ActionEvent event) {
		System.out.print("CourseProfile\n");
		Main.changeScreen("view/CourseProfile.fxml");
	}

	@FXML
	private void handleRegisterCourse(ActionEvent event) {
		System.out.print("RegisterCourse\n");
		Main.changeScreen("view/RegisterCourse.fxml");
	}

}
