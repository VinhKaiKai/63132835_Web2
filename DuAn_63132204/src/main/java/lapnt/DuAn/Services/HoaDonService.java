package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.HoaDon;
import lapnt.DuAn.Repositories.HoaDonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    // Lấy danh sách hóa đơn
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    // Lưu hóa đơn mới hoặc cập nhật hóa đơn
    public void saveHoaDon(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }

    // Lấy hóa đơn theo ID
    public HoaDon getHoaDonById(int id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    // Xóa hóa đơn
    public void deleteHoaDon(int id) {
        hoaDonRepository.deleteById(id);
    }
    
    public List<HoaDon> getHoaDonByDateRange(LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.findByNgaygdBetween(startDate, endDate);
    }

    public int countTongHD(List<HoaDon> hoadon) {
        return hoadon.size();
    }
}

