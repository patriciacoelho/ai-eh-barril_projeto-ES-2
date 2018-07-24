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
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Course userData) {
				if(newScreen.equals("SearchCourse")) {
					search.setText("");
				}
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
	private void handleSearch(ActionEvent event) {// nao terminado
		List<Course> course;
		course = Course.whereAlias(search.getText());
		if(course.isEmpty()) {
			 Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Erro");
             alert.setContentText("Disciplina não encontrada!");
             alert.showAndWait();
		} else {
			Main.changeScreen("view/CourseProfile.fxml",course.get(0));
		}
		
	}
}
