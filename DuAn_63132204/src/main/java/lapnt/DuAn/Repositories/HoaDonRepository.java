package lapnt.DuAn.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lapnt.DuAn.Models.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
	List<HoaDon> findByNgaygdBetween(LocalDate startDate, LocalDate endDate);
}

