package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.KhachHang;
import lapnt.DuAn.Repositories.KhachHangRepository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    // Lấy danh sách khách hàng
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    // Lưu khách hàng mới
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    // Lấy khách hàng theo ID
    public KhachHang getKhachHangById(int id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    // Xóa khách hàng
    public void deleteKhachHang(int id) {
        khachHangRepository.deleteById(id);
    }
    
    public List<KhachHang> searchByName(String hotenkh) {
        return khachHangRepository.findByHotenkhContaining(hotenkh);
    }
    
    public Page<KhachHang> searchByName(String hotenkh, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return khachHangRepository.findByHotenkhContaining(hotenkh, pageable);
    }
}


