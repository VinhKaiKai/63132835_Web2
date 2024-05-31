package lapnt.DuAn.Repositories;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lapnt.DuAn.Models.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	List<KhachHang> findByHotenkhContaining(String hotenkh);
	Page<KhachHang> findByHotenkhContaining(String hotenkh, Pageable pageable);
}

