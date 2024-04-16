package vinhhoccode.spring.models;

import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class Student {

	private int id;
	private String name;
	private float mark;
	private Major major;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Student() {
		
	}
	public Student(int id, String name, float mark, Major major) {
		
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.major = major;
	}
	
}
