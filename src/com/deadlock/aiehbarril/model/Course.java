package com.deadlock.aiehbarril.model;

//import java.time.LocalDate;

//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Model para uma Course (disciplina).
 */
public class Course {

    private final StringProperty alias;
    private final StringProperty professor;
    private final StringProperty code;
//    private final ObjectProperty<Rating> rate;

    public Course() {
        this(null, null);
    }

    /**
     * @param alias nome da disciplina.
     * @param professor professor que leciona a disciplina.
     */
    public Course(String alias, String professor) {
        this.alias = new SimpleStringProperty(alias);
        this.professor = new SimpleStringProperty(professor);

        // Alguns dados de exemplo, apenas para testes.
        this.code = new SimpleStringProperty("#");
//        this.rate = new SimpleObjectProperty<Rating>();
    }

    public String getAlias() {
        return alias.get();
    }

    public void setAlias(String newAlias) {
        this.alias.set(newAlias);
    }

    public StringProperty aliasProperty() {
        return alias;
    }

    public String getProfessor() {
        return professor.get();
    }

    public void setProfessor(String newProfessor) {
        this.professor.set(newProfessor);
    }

    public StringProperty professorProperty() {
        return professor;
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String newCode) {
        this.code.set(newCode);
    }

    public StringProperty codeProperty() {
        return code;
    }

    /* ToDo - add getter e setter para  o objeto rating*/
}
