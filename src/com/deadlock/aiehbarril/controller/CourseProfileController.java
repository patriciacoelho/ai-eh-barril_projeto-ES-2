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

	@FXML
    private Label lbl_media_explanation;

    @FXML
    private Label lbl_media_examDificulty_text;

    @FXML
    private Label lbl_media_presence;

    @FXML
    private Label lbl_media_presence_text;

    @FXML
    private Label lbl_porcentagemEhBarril;

    @FXML
    private Label lbl_headAlias;

    @FXML
    private Label lbl_numVotos;

    @FXML
    private Label lbl_media_projects_text;

    @FXML
    private Label lbl_media_free_to_answers_text;

    @FXML
    private Label lbl_media_projects;

    @FXML
    private Label lbl_media_confidence;

    @FXML
    private Label lbl_media_explanation_text;

    @FXML
    private Label lbl_media_confidence_text;

    @FXML
    private Label lbl_media_examDificulty;

    @FXML
    private Label lbl_media_free_to_answers;

    @FXML
    private Label lbl_headProfessor;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Course userData) {
				if(newScreen.equals("CourseProfile")) {
					
					
					lbl_headAlias.setText(userData.getAlias());
					lbl_headProfessor.setText(userData.getProfessor());
					
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
