package com.learncode.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.learncode.models.SinhVien;


@Service
public interface SinhvienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
}
