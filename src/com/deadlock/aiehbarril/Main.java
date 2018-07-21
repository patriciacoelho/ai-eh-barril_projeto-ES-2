package com.deadlock.aiehbarril;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import com.deadlock.aiehbarril.model.Course;

public class Main extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;

    /** Os dados como uma observable list de Courses.	*/
    private ObservableList<Course> courseData = FXCollections.observableArrayList();

    /** Construtor  */
    public Main() {
        // Add some sample data
    	courseData.add(new Course("C�lculo III", "Edson"));
    	courseData.add(new Course("Eng. de Software I", "Ricardo"));
    	courseData.add(new Course("Banco de Dados I", "Godoy"));
    	courseData.add(new Course("Redes de computadores I", "F�bio"));
    	courseData.add(new Course("F�sica II", "Paulo"));
    	courseData.add(new Course("F�sica I", "Wagner"));
    	courseData.add(new Course("C�lculo Num�rico", "Jorge"));
    	courseData.add(new Course("C�lculo II", "Beto"));
    	courseData.add(new Course("Estat�stica", "Hugo"));
    }

    /**
     * Retorna os dados como uma observable list de Courses.
     * @return
     */
    public ObservableList<Course> getCourseData() {
        return courseData;
    }

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("");

        initRootLayout();

        showSearchCourse();

	}

	/**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra a view SearchCourse dentro do root layout.
     */
    public void showSearchCourse() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/SearchCourse.fxml"));
            AnchorPane searchCourse = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(searchCourse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Chamado quando o usu�rio clica em cadastrar disciplina.
     * Abre a view RegisterCourse
     */
    @FXML
    private void handleRegisterCourse() {
    	try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RegisterCourse.fxml"));
            AnchorPane registerCourse = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(registerCourse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
