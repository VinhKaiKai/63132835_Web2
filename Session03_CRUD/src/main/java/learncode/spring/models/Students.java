package learncode.spring.models;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Students")
public class Students {
	@Id
	@Column(length = 10)
	private String id;
	
	@Column(length = 50)
	private String name;
	
	private boolean gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ngaydangkyhoc;
	
	@Column(length = 500)
	private String photo;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 12)
	private String phone;
	
	private boolean hthocphi;
	
	
	// nối dây qua bảng course
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="courseId")
	private Courses courses;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="staffId")
	private Staffs staffs;

	public Students() {
		super();
	}

	public Students(String id, String name, boolean gender, Date birthday, Date ngaydangkyhoc, String photo,
			String email, String phone, boolean hthocphi, Courses courses, Staffs staffs) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.ngaydangkyhoc = ngaydangkyhoc;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.hthocphi = hthocphi;
		this.courses = courses;
		this.staffs = staffs;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getNgaydangkyhoc() {
		return ngaydangkyhoc;
	}

	public void setNgaydangkyhoc(Date ngaydangkyhoc) {
		this.ngaydangkyhoc = ngaydangkyhoc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isHthocphi() {
		return hthocphi;
	}

	public void setHthocphi(boolean hthocphi) {
		this.hthocphi = hthocphi;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public Staffs getStaffs() {
		return staffs;
	}

	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}



	

	
	
}
