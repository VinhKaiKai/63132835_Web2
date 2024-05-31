package lapnt.DuAn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lapnt.DuAn.Models.CTHDSanPham;

public interface CTHDSanPhamRepository extends JpaRepository<CTHDSanPham, Integer> {
	//List<CTHDSanPham> findByHoaDonId(int idhd);
}

