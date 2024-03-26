package thiGK.ntu63132835.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import thiGK.ntu63132835.models.SinhVien;
public interface SinhVienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
	
	
	// làm phần phần service tìm kiếm , trả dữ liệu, thêm mới 
	List<SinhVien> getAllStudents();
    SinhVien getStudentById(String id);
    void addStudent(SinhVien student);
}




