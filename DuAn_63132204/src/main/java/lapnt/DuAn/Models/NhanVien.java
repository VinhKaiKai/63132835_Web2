package lapnt.DuAn.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnv")
    private int idnv;

    @Column(name = "hotennv")
    private String hotennv;

    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @Column(name = "gioitinh")
    private String gioitinh;

    @Column(name = "diachinv")
    private String diachinv;

    @Column(name = "emailnv")
    private String emailnv;

    @Column(name = "sdtnv")
    private String sdtnv;

	public int getIdnv() {
		return idnv;
	}

	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}

	public String getHotennv() {
		return hotennv;
	}

	public void setHotennv(String hotennv) {
		this.hotennv = hotennv;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachinv() {
		return diachinv;
	}

	public void setDiachinv(String diachinv) {
		this.diachinv = diachinv;
	}

	public String getEmailnv() {
		return emailnv;
	}

	public void setEmailnv(String emailnv) {
		this.emailnv = emailnv;
	}

	public String getSdtnv() {
		return sdtnv;
	}

	public void setSdtnv(String sdtnv) {
		this.sdtnv = sdtnv;
	}

    
}
