package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	//전체조회
	public List<Emp> selectAll();
	
	public List<Emp> selectDeptno20();
	//지정된 부서 사원들 조회
	public List<Emp> selectByDeptno(int deptno);
	//새로운 사원정보 삽입
	public void insert(Emp emp);
	
}
