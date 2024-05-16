package lapnt.DuAn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lapnt.DuAn.Models.CTHDDichVu;

public interface CTHDDichVuRepository extends JpaRepository<CTHDDichVu, Integer> {
	//List<CTHDDichVu> findByHoaDonId(int idhd);
}

