package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.DichVu;
import lapnt.DuAn.Repositories.DichVuRepository;

import java.util.List;

@Service
public class DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;

    // Lấy danh sách dịch vụ
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }

    // Lưu dịch vụ mới hoặc cập nhật dịch vụ
    public void saveDichVu(DichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    // Lấy dịch vụ theo ID
    public DichVu getDichVuById(int id) {
        return dichVuRepository.findById(id).orElse(null);
    }

    // Xóa dịch vụ
    public void deleteDichVu(int id) {
        dichVuRepository.deleteById(id);
    }
}

