package ojdbc;

import java.sql.*;
public class OjdbcEx_02 {

	//OJDBC드라이버
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1="";
		sql1 +="CREATE TABLE userTest(";
		sql1+="	idx NUMBER CONSTRAINT pk_user_test PRIMARY KEY,";
		sql1+="	name VARCHAR2(50) NOT NULL,";
		sql1+="	phone VARCHAR2(50) NOT NULL)";
		
		String sql2="";
		sql2+="CREATE SEQUENCE seq_usertest";
		sql2+="	INCREMENT BY 1";
		sql2+="	START WITH 1";
		try {
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st=conn.createStatement();
			//st.execute(sql1);//테이블 생성
			//st.execute(sql2);//시퀸스 생서 쿼리
			//-----------------------
			//생성 후 결과 처리
			//-----------------------
			
//------------------------------------테이블 생성여부 코드--------------------------------		
			
			rs=st.executeQuery("select count(*) from tabs"
					+" where table_name=upper('usertest')");
			
			rs.next();
			//rs.getInt("count(*)")
			if(rs.getInt(1)>0) {
				System.out.println("테이블 생성 완료");
			}else {
				System.out.println("테이블 생성 실패");
			}
//------------------------------------시퀀스 생성여부 코드--------------------------------		
			
			rs=st.executeQuery("select count(*) from SEQ"
					+" where sequence_name=upper('seq_usertest')");
			
			rs.next();
			//rs.getInt("count(*)")
			if(rs.getInt(1)>0) {
				System.out.println("시퀀스 생성 완료");
			}else {
				System.out.println("시퀀스 생성 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs !=null)rs.close();
			if(st !=null)st.close();
			if(conn !=null)conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
