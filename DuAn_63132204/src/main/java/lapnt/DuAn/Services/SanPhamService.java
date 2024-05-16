package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.SanPham;
import lapnt.DuAn.Repositories.SanPhamRepository;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Lấy danh sách sản phẩm
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    // Lưu sản phẩm mới hoặc cập nhật sản phẩm
    public void saveSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    // Lấy sản phẩm theo ID
    public SanPham getSanPhamById(int id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    // Xóa sản phẩm
    public void deleteSanPham(int id) {
        sanPhamRepository.deleteById(id);
    }
}
