package learncode.spring.models;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "Courses")
public class Courses {
	@Id
	@Column(length = 15)
	private String id;
	// tên khóa học
	@Column(length = 100)
	private String name;
	//ghi chú khóa học
	@Column(length = 500)
	private String note;
	
	// giá khóa học
	private Float price;
	// thời gian khóa học
	
	@Column(length = 30)
	private String timecourse;
	
	
	// nối dây qua bảng students 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courses")
	private Set<Students> students;


	public Courses() {
		super();
	}


	public Courses(String id) {
	    this.id = id;
	}
	public Courses(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Courses(String id, String name, String note, Float price, String timecourse, Set<Students> students) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.price = price;
		this.timecourse = timecourse;
		this.students = students;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getTimecourse() {
		return timecourse;
	}


	public void setTimecourse(String timecourse) {
		this.timecourse = timecourse;
	}


	public Set<Students> getStudents() {
		return students;
	}


	public void setStudents(Set<Students> students) {
		this.students = students;
	}


	

	

	

	
	
}
