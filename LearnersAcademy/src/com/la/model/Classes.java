package com.la.model;

public class Classes {

	private int classid;
	private String classname;

	public Classes() {
		super();
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String string) {
		this.classname = string;
	}
	@Override
	public String toString() {
		return "Classes [classid=" + classid + ", classname=" + classname + "]";
	}
	
	
	
}
