package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.NhanVien;
import lapnt.DuAn.Repositories.NhanVienRepository;
import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Lấy danh sách nhân viên
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    // Lưu nhân viên mới
    public void saveNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    // Lấy nhân viên theo ID
    public NhanVien getNhanVienById(int id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    // Xóa nhân viên
    public void deleteNhanVien(int id) {
        nhanVienRepository.deleteById(id);
    }
    public List<NhanVien> searchByName(String hotennv) {
        return nhanVienRepository.findByHotennvContaining(hotennv);
    }
}
