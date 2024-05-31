package lapnt.DuAn.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "cthdsanpham")
public class CTHDSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcthd")
    private int idcthd;

    @ManyToOne
    @JoinColumn(name = "idhd")
    private HoaDon hoaDon;
    
    @ManyToOne
    @JoinColumn(name = "idsp")
    private SanPham sanPham;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "tong")
    private double tong;
 // Getters and Setters
	public int getIdcthd() {
		return idcthd;
	}

	public void setIdcthd(int idcthd) {
		this.idcthd = idcthd;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getTong() {
		return tong;
	}

	public void setTong(double tong) {
		this.tong = tong;
	}

    
    
}
