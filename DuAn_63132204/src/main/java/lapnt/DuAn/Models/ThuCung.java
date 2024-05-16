package lapnt.DuAn.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "thucung")
public class ThuCung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpet")
    private int idpet;

    @Column(name = "tenpet")
    private String tenpet;

    @Column(name = "loai")
    private String loai;

    @Column(name = "tinhtrang")
    private String tinhtrang;
    
    @ManyToOne
    @JoinColumn(name = "idkh")
    private KhachHang khachHang;
    
 // Getters and Setters
	public int getIdpet() {
		return idpet;
	}

	public void setIdpet(int idpet) {
		this.idpet = idpet;
	}

	public String getTenpet() {
		return tenpet;
	}

	public void setTenpet(String tenpet) {
		this.tenpet = tenpet;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
    
    
}
