package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

public class MemberDao {
	private PreparedStatement ps = null; 
	private ResultSet rs = null;

	public Member loginCheck(Connection conn, String userId,String userPwd) {
		String sql="";
		sql +="select userid,userpwd from Member";
		sql +=" where userid=?";
		sql+=" and userpwd=?";
		
		Member mem=new Member();
				
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPwd);
			Boolean bool=ps.execute();
			
			if(bool) {//아이디와 패스워드가 존재하면 회원 정보를 보냄
			
			rs.next();
			mem.setUserId(rs.getString("userId"));
			mem.setUserPwd(rs.getString("userpwd"));
			mem.setUserName(rs.getString("username"));
			mem.setGender(rs.getString("gender"));
			mem.setAge(rs.getInt("age"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setHobby(rs.getString("hobby"));
			mem.setEtc(rs.getString("etc"));
			mem.setEnrollDate(rs.getDate("enrollDate"));
			mem.setLastModified(rs.getDate("lastModified"));
			}else {
				mem=null;//존재하지 않으면 null보냄
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
		return mem;
		
	}
	
	public int insertMember(Connection conn,Member member) {
		String sql="";
		sql+="insert into member";
		sql+=" values(?,?,?,?,?,?,?,?,?)";
		int test=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserPwd());
			ps.setString(3, member.getUserName());
			ps.setString(4, member.getGender());
			ps.setInt(5, member.getAge());
			ps.setString(6, member.getPhone());
			ps.setString(7, member.getEmail());
			ps.setString(8, member.getHobby());
			ps.setString(9, member.getEtc());
			ps.setDate(10, member.getEnrollDate());
			ps.setDate(11, member.getLastModified());
			test=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return test;}
	
	public int deleteMember(Connection conn, String userId) {
		
		String sql="";
		sql+="delete from Member";
		sql+=" where userid=?";
		int test=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userId);
			test=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(ps !=null)ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return test;
		}
	
	
	public Member selectOne(Connection conn,String userId) {
		String sql="";
		sql+="select * from Member";
		sql+=" where userId=?";
		Member mem=new Member();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			rs.next();
			mem.setUserId(rs.getString("userId"));
			mem.setUserPwd(rs.getString("userpwd"));
			mem.setUserName(rs.getString("username"));
			mem.setGender(rs.getString("gender"));
			mem.setAge(rs.getInt("age"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setHobby(rs.getString("hobby"));
			mem.setEtc(rs.getString("etc"));
			mem.setEnrollDate(rs.getDate("enrollDate"));
			mem.setLastModified(rs.getDate("lastModified"));
			
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
		return null;}
	
	public List<Member> selectList(Connection conn){
		
		String sql="";
		sql +="select * from Member";
		List<Member> list=new ArrayList();
		
		try {
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Member mem=new Member();
				mem.setUserId(rs.getString("userId"));
				mem.setUserPwd(rs.getString("userpwd"));
				mem.setUserName(rs.getString("username"));
				mem.setGender(rs.getString("gender"));
				mem.setAge(rs.getInt("age"));
				mem.setPhone(rs.getString("phone"));
				mem.setEmail(rs.getString("email"));
				mem.setHobby(rs.getString("hobby"));
				mem.setEtc(rs.getString("etc"));
				mem.setEnrollDate(rs.getDate("enrollDate"));
				mem.setLastModified(rs.getDate("lastModified"));
				list.add(mem);
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
		
		return list;}
			
			
}
