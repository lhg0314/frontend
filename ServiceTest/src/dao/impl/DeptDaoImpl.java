package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dto.Dept;


public class DeptDaoImpl implements DeptDao {


	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;//db연결 객체
	
	private static PreparedStatement ps=null;//sql수행객체
	
	private static ResultSet rs=null;//조회결과 객체
	

	public DeptDaoImpl(){
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
	public List<Dept> selectAll() {
		String sql="";
		sql+="select * from dept";
		sql+=" order by deptno";
		List<Dept> list=new ArrayList<Dept>();
		
		try {
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				
				Dept dept=new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null)rs.close();
				if(ps !=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		 String sql = "";
	      sql += "insert into Dept( deptno, dname, loc )";
	      sql += " values (?, ?, ?)";
	      
	      try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dept.getDeptno()); 
	        ps.setString(2, dept.getDname()); 
	        ps.setString(3, dept.getLoc()); 
	        int test=ps.executeUpdate();
	        System.out.println(test);
	        
	        conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
	         try {
		            
		            if(ps!=null)   ps.close();
		            //-----------------
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
	}

	}
	
}
