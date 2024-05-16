package lapnt.DuAn.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lapnt.DuAn.Models.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
	List<NhanVien> findByHotennvContaining(String hotennv);
}

