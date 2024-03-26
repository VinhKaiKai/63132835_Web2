package thiGK.ntu63132835.models;

public class SinhVien {
	private String maSoSV;
	private String hoVaTen;
	private int diemTichLuy;
	
	
	
	public String getMaSoSV() {
		return maSoSV;
	}
	public void setMaSoSV(String maSoSV) {
		this.maSoSV = maSoSV;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	
	public String getDiemTichLuy() {
		return maSoSV;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public SinhVien(String maSoSV, String hoVaTen, int diemTichLuy) {
		this.maSoSV = maSoSV;
		this.hoVaTen = hoVaTen;
		this.diemTichLuy= diemTichLuy;
	}
}
