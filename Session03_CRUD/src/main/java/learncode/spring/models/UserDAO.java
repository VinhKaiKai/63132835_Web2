package learncode.spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicDesktopPaneUI;

public class UserDAO {

	//Định nghĩa các phương thức thêm xóa sửa
	public static List<User> ls = new ArrayList<User>();
	
	
	//Ham tim kiem
	public User findByUsername( String username) {
		
		for (User user : ls)
		{
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
		
	}
	
	// ham Update
	public int update(User user)
	{
		for (int i = 0 ; i< ls.size(); i++) {
			if(ls.get(i).getUsername().equals(user.getUsername()))
			{
				ls.set(i,user);
				return i;// update
			}
		}
		return -1; // ko tim thay
	}
	
	
	// ham luu
	public int save (User user)
	{
		if(findByUsername(user.getUsername())!=null)
		{
			update(user); // neu tim thay thi update
		}
		else {
			ls.add(user); // ko tim thay thi them
		}
		return 1;
	}
	
	
	//ham xoa
	public int delete(String username)
	{
		User u = findByUsername(username);
		if(u != null)
		{
			ls.remove(u); // tim thay thi xoa
			return 1;
		}
		return 0;
	}
	
	
	// ham hien thi DS
	public List<User> getAll(){
		return ls;
	}
	
}
