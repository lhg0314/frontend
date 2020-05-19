package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//싱글톤 적용 객체-DB연결
//Connection 객체를 하나만 만들어서 사용할수 있게 만든다
public class DBConn {
	
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	
	private static Connection conn=null;//db연결 객체
	
	//private 생성자-외부에서 객체생성하는 걸 막는 용도
	private DBConn() {}
	
	//Connection 객체 반환-싱글톤 패턴 적용 메소드
	public static Connection getConnection() {
		
		if(conn==null) {
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
		
		return conn;
	}
	


}
