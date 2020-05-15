package ex;

import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

public class Empex {

	private static EmpDao empDao =new EmpDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Emp> list=empDao.selectAll();
		
		for(Emp emp:list) {
			System.out.println(emp);
		}
		
		
	}

}
