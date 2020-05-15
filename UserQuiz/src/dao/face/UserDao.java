package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {

	public List<User> selectAll();
	
	public List<User> insertUser(User user);
	
	public User selectByIdx(int idx);
	
	public List<User> deleteByIdx(int idx);
	

}
