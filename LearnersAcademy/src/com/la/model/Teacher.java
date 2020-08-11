package com.la.model;

public class Teacher {
	private int t_id;
	private String t_name;
	private int t_age;
	private int t_salary;
	private int t_experience;
	private String subjectname;
	private int classid;
	public Teacher(String t_name, int t_age, int t_salary, int t_experience, String subjectname, int classid) {
		super();
		this.t_name = t_name;
		this.t_age = t_age;
		this.t_salary = t_salary;
		this.t_experience = t_experience;
		this.subjectname = subjectname;
		this.classid = classid;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", t_name=" + t_name + ", t_age=" + t_age + ", t_salary=" + t_salary
				+ ", t_experience=" + t_experience + ", subjectname=" + subjectname + ", classid=" + classid + "]";
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getT_age() {
		return t_age;
	}
	public void setT_age(int t_age) {
		this.t_age = t_age;
	}
	public int getT_salary() {
		return t_salary;
	}
	public void setT_salary(int t_salary) {
		this.t_salary = t_salary;
	}
	public int getT_experience() {
		return t_experience;
	}
	public void setT_experience(int t_experience) {
		this.t_experience = t_experience;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
	

}
