package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;
import com.deadlock.aiehbarril.model.Course;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;


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
	ComboBox<String> suggestionsPane = new ComboBox<>();
	@FXML
	private VBox pane;
	
	
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
	private void handleSearch(KeyEvent event) {
		ArrayList<Course> result = new ArrayList<>();
		String course = search.getText();
		System.out.print("***"+course);
		if(Course.whereAlias(course).isEmpty()) {
			System.out.print("Discilina nao encontrada");
		} else {
			int i = 0;
			int size = Course.whereAlias(course).size();
			for(i=0;i<size;i++) {
				result.add(Course.whereAlias(course).get(i));
				i++;
			}
			System.out.println(result.toString());
//			while(!result.isEmpty()) {
//				
//			}
			//result.add(Course.whereAlias(course).get(0));
//			suggestionsPane.getItems().add(result.get(0).getAlias());
//			pane.getChildren().add(suggestionsPane);  
//			pane.setLayoutX(10);
//			pane.setLayoutY(10);
		}
		
		
		
		
	}
		
}
