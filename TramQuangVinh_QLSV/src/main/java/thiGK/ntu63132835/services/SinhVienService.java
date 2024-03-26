package thiGK.ntu63132835.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import thiGK.ntu63132835.models.SinhVien;
public interface SinhVienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
}
