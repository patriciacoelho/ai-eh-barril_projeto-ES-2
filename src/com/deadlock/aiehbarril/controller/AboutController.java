package com.deadlock.aiehbarril.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.deadlock.aiehbarril.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AboutController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void handleSearchCourse(ActionEvent event) {
		System.out.print("SearchCourse\n");
		Main.changeScreen("view/SearchCourse.fxml");
	}

}
