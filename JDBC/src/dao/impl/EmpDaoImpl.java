package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {
	
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;//db연결 객체
	
	private static PreparedStatement ps=null;//sql수행객체
	
	private static ResultSet rs=null;//조회결과 객체

	
	public EmpDaoImpl() {
		
		try {
			Class.forName(DRIVER);
			
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	@Override
	public List<Emp> selectAll() {

		//----SQL작성----
		
		String sql="";
		sql+="select * from emp";
		sql+=" order by empno";
		
		//------------결과저장 리스트 만들기
		
		List<Emp> list=new ArrayList<Emp>();
		
		try {
			//sql 수행객체 생성
			ps=conn.prepareStatement(sql);
			//sql수행및 결과 저장
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Emp emp=new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		//----------------
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		return list;
	}

	@Override
	public List<Emp> selectDeptno20() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql="";
		sql+="select * from emp";
		sql+=" where deptno='20'";
		sql+=" order by empno";
		
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> selectByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	
	
}
