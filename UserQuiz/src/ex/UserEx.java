package ex;

import java.util.List;

import dao.face.UserDao;
import dao.impl.UserDaoImpl;
import dto.User;

public class UserEx {
	
	// DAO 생성
	private static UserDao userDao=new UserDaoImpl(); // 동작되도록 바꾸세요!!

	public static void main(String[] args) {
		
		//--- 전체 출력 ---
		List<User> list = userDao.selectAll();
		for(User u : list) {
			System.out.println(u);
		}
		//-----------------

		
		
		//--- 유저 삽입 ---
		// 유저 객체를 생성하고
		// 유저 정보를 객체에 입력하고
		//DB에 삽입되도록 구현하세요!!
		User user=new User();
		user.setName("Alice");
		user.setUserid("A123");
		//	userId : A123
		//	name : Alice
		
		User insertUser = user;
		userDao.insertUser(insertUser);
		//-----------------
		
		
		
		//--- 유저 조회 ---
		System.out.println("");
		User selectUser = (User) userDao.selectByIdx(20);
		System.out.println(selectUser);
		//-----------------
		
		
		
		//--- 유저 삭제 ---
		userDao.deleteByIdx(20);
				
		// 유저 조회 - 삭제됐는지 확인하는 용도(null나와야함)
		User resultUser = (User) userDao.selectByIdx(20);
		System.out.println(resultUser);
		//-----------------
	}
}

	
	
	
	
	
	
	
	
	
	