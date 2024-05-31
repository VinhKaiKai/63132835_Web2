package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.CTHDDichVu;
import lapnt.DuAn.Repositories.CTHDDichVuRepository;

import java.util.List;

@Service
public class CTHDDichVuService {

    @Autowired
    private CTHDDichVuRepository cthdDichVuRepository;

    // Lấy danh sách chi tiết hóa đơn dịch vụ
    public List<CTHDDichVu> getAllCTHDDichVu() {
        return cthdDichVuRepository.findAll();
    }

    // Lưu chi tiết hóa đơn dịch vụ mới hoặc cập nhật
    public void saveCTHDDichVu(CTHDDichVu cthdDichVu) {
        cthdDichVuRepository.save(cthdDichVu);
    }

    // Lấy chi tiết hóa đơn dịch vụ theo ID
    public CTHDDichVu getCTHDDichVuById(int id) {
        return cthdDichVuRepository.findById(id).orElse(null);
    }

    // Xóa chi tiết hóa đơn dịch vụ
    public void deleteCTHDDichVu(int id) {
        cthdDichVuRepository.deleteById(id);
    }
    
//    public List<CTHDDichVu> findByHoaDonId(int idhd) {
//        return cthdDichVuRepository.findByHoaDonId(idhd);
//    }
}

