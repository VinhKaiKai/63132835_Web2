package lapnt.DuAn.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "cthddichvu")
public class CTHDDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcthd")
    private int idcthd;

    @ManyToOne
    @JoinColumn(name = "idhd")
    private HoaDon hoaDon;
    
    @ManyToOne
    @JoinColumn(name = "iddv")
    private DichVu dichVu;
    
    @ManyToOne
    @JoinColumn(name = "idpet")
    private ThuCung thuCung;

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

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public ThuCung getThuCung() {
		return thuCung;
	}

	public void setThuCung(ThuCung thuCung) {
		this.thuCung = thuCung;
	}

	public double getTong() {
		return tong;
	}

	public void setTong(double tong) {
		this.tong = tong;
	}


    
}
