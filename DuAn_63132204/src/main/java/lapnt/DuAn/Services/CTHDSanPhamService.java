package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.CTHDSanPham;
import lapnt.DuAn.Repositories.CTHDSanPhamRepository;

import java.util.List;

@Service
public class CTHDSanPhamService {

    @Autowired
    private CTHDSanPhamRepository cthdSanPhamRepository;

    // Lấy danh sách chi tiết hóa đơn sản phẩm
    public List<CTHDSanPham> getAllCTHDSanPham() {
        return cthdSanPhamRepository.findAll();
    }

    // Lưu chi tiết hóa đơn sản phẩm mới hoặc cập nhật
    public void saveCTHDSanPham(CTHDSanPham cthdSanPham) {
        cthdSanPhamRepository.save(cthdSanPham);
    }

    // Lấy chi tiết hóa đơn sản phẩm theo ID
    public CTHDSanPham getCTHDSanPhamById(int id) {
        return cthdSanPhamRepository.findById(id).orElse(null);
    }

    // Xóa chi tiết hóa đơn sản phẩm
    public void deleteCTHDSanPham(int id) {
        cthdSanPhamRepository.deleteById(id);
    }
//    public List<CTHDSanPham> findByHoaDonId(int idhd) {
//        return cthdSanPhamRepository.findByHoaDonId(idhd);
//    }
}
