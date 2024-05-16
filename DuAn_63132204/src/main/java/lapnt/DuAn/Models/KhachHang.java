package lapnt.DuAn.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkh")
    private int idkh;

    @Column(name = "hotenkh")
    private String hotenkh;

    @Column(name = "diachikh")
    private String diachikh;

    @Column(name = "emailkh")
    private String emailkh;

    @Column(name = "sdtkh")
    private String sdtkh;


    // Getters and Setters
    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public String getHotenkh() {
        return hotenkh;
    }

    public void setHotenkh(String hotenkh) {
        this.hotenkh = hotenkh;
    }

    public String getDiachikh() {
        return diachikh;
    }

    public void setDiachikh(String diachikh) {
        this.diachikh = diachikh;
    }

    public String getEmailkh() {
        return emailkh;
    }

    public void setEmailkh(String emailkh) {
        this.emailkh = emailkh;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

}

