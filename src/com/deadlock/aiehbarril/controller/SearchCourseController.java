package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
	
	String course = null;
	@FXML
	private void handleSearch(KeyEvent event) {// nao terminado
		String course = new String(); //tá mostrando todo mundo que tá cadastrado no banco
		List<Course> result;
		course += event.getText();
		result = Course.whereAlias(course);
		System.out.print(result.toString());
		
	}
}
