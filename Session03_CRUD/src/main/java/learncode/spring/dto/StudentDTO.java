package learncode.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class StudentDTO {

	private String id;
	private String name;
	private boolean gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ngaydangkyhoc;
	private MultipartFile photo;
	private String email;
	private String phone;
	private boolean hthocphi;
	private String courseId;
	private String staffId;
	public StudentDTO() {
		super();
	}
	public StudentDTO(String id, String name, boolean gender, Date birthday, Date ngaydangkyhoc, MultipartFile photo,
			String email, String phone, boolean hthocphi, String courseId, String staffId) {
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
		this.courseId = courseId;
		this.staffId = staffId;
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
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	
	
	
}
