package lapnt.DuAn.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "dichvu")
public class DichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddv")
    private int iddv;

    @Column(name = "tendv")
    private String tendv;

    @Column(name = "mota")
    private String mota;

    @Column(name = "gia")
    private double gia;

    // Getters and Setters
	public int getIddv() {
		return iddv;
	}

	public void setIddv(int iddv) {
		this.iddv = iddv;
	}

	public String getTendv() {
		return tendv;
	}

	public void setTendv(String tendv) {
		this.tendv = tendv;
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
