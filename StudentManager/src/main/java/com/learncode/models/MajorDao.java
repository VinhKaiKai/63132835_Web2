package com.learncode.models;

import java.util.ArrayList;
import java.util.List;

public class MajorDao {

	public static List<Major> ls = new ArrayList();
	public List<Major> getAll(){
		ls.clear();
		ls.add(new Major(1,"PHP"));
		ls.add(new Major(1,"WEB"));
		ls.add(new Major(1,"Vinh"));
		ls.add(new Major(1,"LAP"));
		ls.add(new Major(1,"Huy"));
		return ls;
	}
	public Major findByID(int id)
	{
		for (Major major : ls)
		{
			if(major.getId()==id) {
				return major;
			}
		}
		return null;
	}
}
