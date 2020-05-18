package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.UserDao;

import java.sql.Connection;

import dto.User;

public class UserDaoImpl implements UserDao {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;//db연결 객체
	
	private static PreparedStatement ps=null;//sql수행객체
	
	private static ResultSet rs=null;//조회결과 객체
	
	
	public UserDaoImpl(){
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
	public List<User> selectAll() {//전체 출력
		
		String sql="";
		sql+="select * from userTest";
		List<User> list=new ArrayList<User>();
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				User user=new User();
				user.setIdx(rs.getInt("idx"));
				user.setName(rs.getString("name"));
				user.setUserid(rs.getString("userid"));
				list.add(user);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				//if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}

	@Override
	   public void insertUser(User insertUser) {

	      String sql = "";
	      sql += "insert into userTest( idx, userid, name )";
	      sql += " values (userTest_SQ.nextval, ?, ?)";
	      //----------------
	      
	      try {
	         
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, insertUser.getUserid()); 
	         ps.setString(2, insertUser.getName()); 
	         ps.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            
	            if(ps!=null)   ps.close();
	            //-----------------
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	   @Override
	   public void deleteByIdx(int deleteIdx) {
	      
	      String sql = "";
	      sql += "delete usertest";
	      sql += " where idx = ?";
	      //----------------
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         
	         ps.setInt(1, deleteIdx);
	         
	         ps.executeUpdate();
	         //------------------------------
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(ps!=null)   ps.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	@Override
	public User selectByIdx(int idx) {//찾기
		String sql="";
		sql+="select * from userTest";
		sql+=" where idx=?";
		User user=new User();
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			rs.next();
			user.setIdx(rs.getInt("idx"));
			user.setName(rs.getString("name"));
			user.setUserid(rs.getString("userid"));
			
			
			
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
		return user;
	}

	

}
