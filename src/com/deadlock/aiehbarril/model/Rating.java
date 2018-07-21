package com.deadlock.aiehbarril.model;

public class Rating {
	private int explanation;
	private int requires_presence;
	private int exam_dificulty;
	private int free_to_answers;
	private int projects;
	private int confidence;
	private boolean eh_barril;
	

	public Rating() {
		this.explanation = 0;
		this.requires_presence = 0;
		this.exam_dificulty = 0;
		this.free_to_answers = 0;
		this.projects = 0;
		this.confidence = 0;
		this.eh_barril = false;
	}
	
	public int getExplanation() {
		return explanation;
	}
	public void setExplanation(int explanation) {
		this.explanation = explanation;
	}
	public int getRequires_presence() {
		return requires_presence;
	}
	public void setRequires_presence(int requires_presence) {
		this.requires_presence = requires_presence;
	}
	public int getExam_dificulty() {
		return exam_dificulty;
	}
	public void setExam_dificulty(int exam_dificulty) {
		this.exam_dificulty = exam_dificulty;
	}
	public int getFree_to_answers() {
		return free_to_answers;
	}
	public void setFree_to_answers(int free_to_answers) {
		this.free_to_answers = free_to_answers;
	}
	public int getProjects() {
		return projects;
	}
	public void setProjects(int projects) {
		this.projects = projects;
	}
	public int getConfidence() {
		return confidence;
	}
	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}
	public boolean isEh_barril() {
		return eh_barril;
	}
	public void setEh_barril(boolean eh_barril) {
		this.eh_barril = eh_barril;
	}
	
	
	
}
