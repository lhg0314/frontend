package service.impl;

import java.util.List;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {//DeltService를 상속한다
	
	private DeptDao deptDao=new DeptDaoImpl();

	@Override
	public List<Dept> deptList() {
		
		List<Dept> list=deptDao.selectAll();
		return list;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.insertDept(dept);
	}
	

}
