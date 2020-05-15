package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class OjdbcEx_04 {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;//db연결 객체
	
	private static PreparedStatement ps=null;//sql수행객체
	
	private static ResultSet rs=null;//조회결과 객체
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Emp> list=new ArrayList<>();//전체 결과를 저장할 리스트
		
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------------------------
		
		String job="SALESMAN";
		

		
		//---sql작성-------------
//		String sql="";
//		sql+="select * from emp";
//		sql+=" where job='"+job+ "'";
//		sql+=" order by empno";
		
		
		String sql="";
		sql+="select * from emp";
		sql+=" where job=?";
		sql+=" order by empno";
		
		try {
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			//------sql 수행 객체------

			ps=conn.prepareStatement(sql);
			ps.setString(1, job);//SALESMAN 이 'SALESMAN'으로 들어감
			rs=ps.executeQuery();
			//-------------------------
			
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
			
			for(Emp e:list) {
				System.out.println(e);
			}
			
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
