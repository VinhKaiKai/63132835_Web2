package vinhhoccode.spring.models;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public static List<NguoiDung> ls =  new ArrayList<NguoiDung>();
	public NguoiDung timKiemBangTenNguoiDung (String username)
	{
		for (NguoiDung nguoiDung : ls)
		{
			if(nguoiDung.getUsername().equals(username))
			{
				return nguoiDung;
			}
		}
		return null;
	}
	
	public int update(NguoiDung nguoiDung)
	{
		for (int i=0; i< ls.size(); i++)
		{
			if(ls.get(i).getUsername().equals(nguoiDung.getUsername()))
			{
				ls.set(i, nguoiDung);
				return i;
			}
		}
		return -1;
	}
	
	public int save(NguoiDung nguoiDung)
	{
		if(timKiemBangTenNguoiDung(nguoiDung.getUsername())!= null) {
			update(nguoiDung);
			
		}
		else 
		{
			ls.add(nguoiDung);
		}
		return 1;
	}
	
	public int delete(String username)
	{
		NguoiDung u = timKiemBangTenNguoiDung(username);
		if( u != null)
		{
			ls.remove(u);
			return 1;
		}
		return 0;
				
	}
	
	
	public List<NguoiDung> getAll()
	{
		return ls;
	}
}
