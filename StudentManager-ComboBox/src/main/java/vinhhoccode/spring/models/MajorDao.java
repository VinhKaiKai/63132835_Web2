package vinhhoccode.spring.models;


import java.util.List;
import java.util.ArrayList;

public class MajorDao {

	public static List<Major> ls = new ArrayList<>();
	public List<Major> getAll()
	{
		ls.clear();
		ls.add(new Major (1,"Công nghệ Hóa học"));
		ls.add(new Major (2,"Công nghệ Tin học"));
		ls.add(new Major (3,"Công nghệ Thông tin"));
		ls.add(new Major (4,"Công nghệ Tiếng Anh"));
		ls.add(new Major (5,"Công nghệ Tiếng Trung"));
		return ls;
	}
	public Major findByID(int id)
	{
		for(Major major :ls)
		{
			if(major.getId() == id)
			{
				return major;
			}
		}
		return null;
	}
}
