package ojdbc;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.sql.*;
public class OjdbcEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
//JDBC 사용방법
		
//1.JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-----------OJDBC 사용에 필요한 변수들------------
		Connection conn=null;//DB 연결객체(접속 객체)
		Statement st=null;
		ResultSet rs=null;
		//-------------------------------------------------
		
//2.DB접속(연결,Connection)
		
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//3.SQL쿼리 수행
		try {
			//3.1쿼리 수행 객체 생성
			st=conn.createStatement();
			//3.2 SQL수행 및 결과 저장
			rs=st.executeQuery("SELECT * FROM emp order by empno");
			
//4.조회된 결과 처리
			//조회된 행이 존재하는 만큼 반복하는 코드
			while(rs.next()) {
				//rs.next()를 한번 수행할때 마다 조회된 결과에서 
				//순차적으로 한 행씩 참조한다
				
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("empno")+"\t");
				System.out.print(rs.getString("mgr")+"\t");
				System.out.print(rs.getString("hiredate")+"\t");
				System.out.print(rs.getString("sal")+"\t");
				System.out.print(rs.getString("comm")+"\t");
				System.out.print(rs.getString("deptno")+"\t");
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null)rs.close();
				if(st !=null)st.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//5.연결종료
	}

}
