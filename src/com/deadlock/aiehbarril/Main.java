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

import java.util.ArrayList;

import com.deadlock.aiehbarril.model.Course;

public class Main extends Application {

	private static Stage currentStage;

	private static Scene searchCourse;
	private static Scene about;
	private static Scene registerCourse;
	private static Scene courseProfile;
	private static Scene rateCourse;
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

    	Parent fxmlRateCourse = FXMLLoader.load(getClass().getResource("view/RateCourse.fxml"));
    	rateCourse = new Scene(fxmlRateCourse);

    	Parent fxmlLastStepRating = FXMLLoader.load(getClass().getResource("view/LastStepRating.fxml"));
    	lastStepRating = new Scene(fxmlLastStepRating);

    	Parent fxmlRatingFeedback = FXMLLoader.load(getClass().getResource("view/RatingFeedback.fxml"));
    	ratingFeedback = new Scene(fxmlRatingFeedback);

    	primaryStage.setScene(searchCourse);
    	primaryStage.show();

	}

    public static void changeScreen(String url, Course userData) {
    	switch (url){
    	case "view/SearchCourse.fxml":
    		currentStage.setScene(searchCourse);
    		notifyAllListeners("SearchCourse",userData);
    		break;
    	case "view/About.fxml":
    		currentStage.setScene(about);
    		notifyAllListeners("About",userData);
    		break;
    	case "view/RegisterCourse.fxml":
    		currentStage.setScene(registerCourse);
    		notifyAllListeners("RegisterCourse",userData);
    		break;
    	case "view/CourseProfile.fxml":
    		currentStage.setScene(courseProfile);
    		notifyAllListeners("CourseProfile",userData);
    		break;
    	case "view/RateCourse.fxml":
    		currentStage.setScene(rateCourse);
    		notifyAllListeners("RateCourse",userData);
    		break;
    	case "view/LastStepRating.fxml":
    		currentStage.setScene(lastStepRating);
    		notifyAllListeners("LastStepRating",userData);
    		break;
    	case "view/RatingFeedback.fxml":
    		currentStage.setScene(ratingFeedback);
    		notifyAllListeners("RatingFeedback",userData);
    		break;
    	}
    }
    
    public static void changeScreen(String url) {
    	changeScreen(url,null);
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //-------------------
    
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    
    public static interface OnChangeScreen{
    	void onScreenChanged(String newScreen, Course userData);
    }
    
    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
    	listeners.add(newListener);
    }
    
    private static void notifyAllListeners(String newScreen, Course userData) {
    	for(OnChangeScreen l : listeners) {
    		l.onScreenChanged(newScreen, userData);
    	}
    }
    
}
