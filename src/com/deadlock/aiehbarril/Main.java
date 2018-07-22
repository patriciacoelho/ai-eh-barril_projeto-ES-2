package com.deadlock.aiehbarril;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

//import java.io.IOException;

//import javafx.fxml.FXML;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import com.deadlock.aiehbarril.model.Course;

public class Main extends Application {

	private static Stage currentStage;

	private static Scene searchCourse;
	private static Scene about;
	private static Scene registerCourse;
	private static Scene courseProfile;
	private static Scene evaluate;
	private static Scene lastStepRating;
	private static Scene ratingFeedback;

//    private BorderPane rootLayout;

    /** Os dados como uma observable list de Courses.	*/
//    private ObservableList<Course> courseData = FXCollections.observableArrayList();

    /** Construtor  */
    public Main() {
        // Add some sample data
    	int i = 0;

    	Course A = new Course(++i,"C�lculo III", "Edson");
    	A.save();
    	A = new Course(++i,"Eng. de Software I", "Ricardo");
    	A.save();
    	A = new Course(++i,"Banco de Dados I", "Godoy");
    	A.save();
    	A = new Course(++i,"Redes de computadores I", "F�bio");
    	A.save();
    	A = new Course(++i,"F�sica II", "Paulo");
    	A.save();
    	A = new Course(++i,"F�sica I", "Wagner");
    	A.save();
    	A = new Course(++i,"C�lculo Num�rico", "Jorge");
    	A.save();
    	A = new Course(++i,"C�lculo II", "Beto");
    	A.save();
    	A = new Course(++i,"Estat�stica", "Hugo");
    	A.save();

    }

    /**
     * Retorna os dados como uma observable list de Courses.
     * @return
     */
//    public ObservableList<Course> getCourseData() {
//        return courseData;
//    }

    @Override
	public void start(Stage primaryStage) throws Exception {

//    	System.exit(0);

    	currentStage = primaryStage;

    	Parent fxmlSearchCourse = FXMLLoader.load(getClass().getResource("view/SearchCourse.fxml"));
    	searchCourse = new Scene(fxmlSearchCourse);

    	Parent fxmlAbout = FXMLLoader.load(getClass().getResource("view/About.fxml"));
    	about = new Scene(fxmlAbout);

    	Parent fxmlRegisterCourse = FXMLLoader.load(getClass().getResource("view/RegisterCourse.fxml"));
    	registerCourse = new Scene(fxmlRegisterCourse);

    	Parent fxmlCourseProfile = FXMLLoader.load(getClass().getResource("view/CourseProfile.fxml"));
    	courseProfile = new Scene(fxmlCourseProfile);

    	Parent fxmlEvaluate = FXMLLoader.load(getClass().getResource("view/Evaluate.fxml"));
    	evaluate = new Scene(fxmlEvaluate);

    	Parent fxmlLastStepRating = FXMLLoader.load(getClass().getResource("view/LastStepRating.fxml"));
    	lastStepRating = new Scene(fxmlLastStepRating);

    	Parent fxmlRatingFeedback = FXMLLoader.load(getClass().getResource("view/RatingFeedback.fxml"));
    	ratingFeedback = new Scene(fxmlRatingFeedback);

    	primaryStage.setScene(searchCourse);
    	primaryStage.show();

	}

    public static void changeScreen(String url) {
    	switch (url){
    	case "view/SearchCourse.fxml":
    		currentStage.setScene(searchCourse);
    		break;
    	case "view/About.fxml":
    		currentStage.setScene(about);
    		break;
    	case "view/RegisterCourse.fxml":
    		currentStage.setScene(registerCourse);
    		break;
    	case "view/CourseProfile.fxml":
    		currentStage.setScene(courseProfile);
    		break;
    	case "view/Evaluate.fxml":
    		currentStage.setScene(evaluate);
    		break;
    	case "view/LastStepRating.fxml":
    		currentStage.setScene(lastStepRating);
    		break;
    	case "view/RatingFeedback.fxml":
    		currentStage.setScene(ratingFeedback);
    		break;
    	}
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
