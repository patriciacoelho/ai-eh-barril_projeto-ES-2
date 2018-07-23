package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SearchCourseController implements Initializable {
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void initialize() {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				System.out.print("Nova tela "+newScreen+" "+userData);
			}
		});

	}
	
	@FXML
	private TextField search;
	
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
	
	@FXML
	private void handleSearch(ActionEvent event) {
		List<Course> result;
		result = Course.whereAlias(search.getText());
		if(!result.isEmpty()) {
			Main.changeScreen("view/CourseProfile.fxml", result.get(0));
		} else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Disciplina não econtrada!");
            alert.showAndWait();
		}
		
	}
}
