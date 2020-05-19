package service.face;

import java.util.List;

import dto.Dept;

public interface DeptService {
	
	public List<Dept> deptList();
	
	/**
	 * 신규부서 정보입력
	 * @param dept-새롭게 입력될 부서정보
	 */
	public void addDept(Dept dept);
	
}
