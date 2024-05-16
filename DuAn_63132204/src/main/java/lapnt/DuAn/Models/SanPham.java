package lapnt.DuAn.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsp")
    private int idsp;

    @Column(name = "tensp")
    private String tensp;

    @Column(name = "mota")
    private String mota;

    @Column(name = "gia")
    private double gia;

    
    // Constructors, getters, and setters
       
	public int getIdsp() {
		return idsp;
	}

	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
    
}