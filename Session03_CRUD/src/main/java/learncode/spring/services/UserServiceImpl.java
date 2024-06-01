package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import learncode.spring.models.User;
import learncode.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	//Trong cái này là để định nghĩa các chức năng của chúng ta. thêm xóa sửa tìm kiếm
	// tất cả ở trong cái repository giờ chỉ cần gọi ra thôi
	// chuột phải source > deleged method 
	
	@Autowired
	UserRepository  userRepository;
	
	@Override
	public  User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public List<User> saveAll(List<User> entities) {
		return (List<User>)userRepository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public List<User> findAllById(List<String> ids) {
		return (List<User>)userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<User> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	
	// hàm để login
	@Override
	public boolean checkLogin(String username, String password)
	{
		Optional<User> optionalUser = findById(username); // Tìm tên user đã tồn tại trong database 
		if(optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) // nếu optionalUser có tồn tại thì so cái mk 
		{
			return true;
		}
		return false;
	}

	
	
	
	//Tìm kiếm 
	@Override
	public List<User> listAll(String keyword) {
		if (keyword  != null) {
			return userRepository.search(keyword);
		}else
		
		return (List<User>) userRepository.findAll();
	}
	
	
	
	
}
