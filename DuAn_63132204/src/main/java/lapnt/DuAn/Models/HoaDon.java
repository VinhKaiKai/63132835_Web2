package lapnt.DuAn.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhd")
    private int idhd;

    @ManyToOne
    @JoinColumn(name = "idkh")
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "idnv")
    private NhanVien nhanVien;

	@Column(name = "tonghd")
    private double tonghd;

    @Column(name = "ngaygd")
    private Date ngaygd;

 // Getters and Setters
	public int getIdhd() {
		return idhd;
	}

	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}

	public double getTonghd() {
		return tonghd;
	}

	public void setTonghd(double tonghd) {
		this.tonghd = tonghd;
	}

	public Date getNgaygd() {
		return ngaygd;
	}

	public void setNgaygd(Date ngaygd) {
		this.ngaygd = ngaygd;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

    
    
}
