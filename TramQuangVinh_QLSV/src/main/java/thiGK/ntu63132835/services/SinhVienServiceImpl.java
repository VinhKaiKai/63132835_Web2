package thiGK.ntu63132835.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import thiGK.ntu63132835.models.SinhVien;

public class SinhVienServiceImpl implements SinhVienService{
	// Ta hard-code dữ liệu tại đây  để tiện demo------ 
				static List<SinhVien> dsSinhVien=  new ArrayList<SinhVien>();
				static {
								dsSinhVien.add(new SinhVien("0001", "Mai Cường Thọ",10));
								dsSinhVien.add(new SinhVien("0002", "Trần Văn Long",9));
								dsSinhVien.add(new SinhVien("0003", "Phạm Thị Hoa",4));
								dsSinhVien.add(new SinhVien("0004", "Trần Văn Long",2));
								dsSinhVien.add(new SinhVien("0005", "Mai Cường Thọ",1));
								dsSinhVien.add(new SinhVien("0006", "Trần Văn Long",3));
								dsSinhVien.add(new SinhVien("0007", "Mai Cường Thọ",4));
								dsSinhVien.add(new SinhVien("0008", "Trần Văn Long",5));
								dsSinhVien.add(new SinhVien("0009", "Mai Cường Thọ",6));
								dsSinhVien.add(new SinhVien("0010", "Trần Văn Long",7));
								dsSinhVien.add(new SinhVien("0011", "Mai Cường Thọ",8));
								dsSinhVien.add(new SinhVien("0012", "Trần Văn Long",1));
				}
				//----------hết phần hard-code dữ liệu ---------------------
				@Override
				public Page<SinhVien> findPaginated(Pageable pageable) {
					int pageSize = pageable.getPageSize();
			        int currentPage = pageable.getPageNumber();
			        int startItem = currentPage * pageSize;
			        List<SinhVien> list;

			        if (dsSinhVien.size() < startItem) {
			            list = Collections.emptyList();
			        } else {
			            int toIndex = Math.min(startItem + pageSize, dsSinhVien.size());
			            list = dsSinhVien.subList(startItem, toIndex);
			        }
			        Page<SinhVien> sinhvienPage = new PageImpl<SinhVien>(list, PageRequest.of(currentPage, pageSize), dsSinhVien.size());
			        return sinhvienPage;
				}
				
				

				    private List<SinhVien> students = new ArrayList<>();

				    @Override
				    public List<SinhVien> getAllStudents() {
				        return students;
				    }

				    @Override
				    public SinhVien getStudentById(int id) {
				        for (SinhVien student : students) {
				            if (SinhVien.getMaSoSV() == id) {
				                return student;
				            }
				        }
				        return null;
				    }

				    @Override
				    public void addStudent(SinhVien student) {
				        students.add(student);
				    }
				
}
