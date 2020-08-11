package com.la.model;

public class Subject {
	
	private int subjectid;
	private String subjectname;
	private int classid;
	public Subject() {
		super();
	}
	public Subject(int subjectid, String subjectname, int classid) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
		this.classid = classid;
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", subjectname=" + subjectname + ", classid=" + classid + "]";
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
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
