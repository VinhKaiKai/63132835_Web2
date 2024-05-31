package lapnt.DuAn.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lapnt.DuAn.Models.ThuCung;
import lapnt.DuAn.Repositories.ThuCungRepository;

import java.util.List;

@Service
public class ThuCungService {

    @Autowired
    private ThuCungRepository thuCungRepository;

    // Lấy danh sách thú cưng
    public List<ThuCung> getAllThuCung() {
        return thuCungRepository.findAll();
    }

    // Lưu thú cưng mới hoặc cập nhật thú cưng
    public void saveThuCung(ThuCung thuCung) {
        thuCungRepository.save(thuCung);
    }

    // Lấy thú cưng theo ID
    public ThuCung getThuCungById(int id) {
        return thuCungRepository.findById(id).orElse(null);
    }

    // Xóa thú cưng
    public void deleteThuCung(int id) {
        thuCungRepository.deleteById(id);
    }
}

