package ojdbc;

import java.sql.*;

public class OjdbcEx_03 {
	
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	private static Connection conn=null;//db연결 객체
	
	private static Statement st=null;//sql수행객체
	private static PreparedStatement ps=null;//sql수행객체
	
	private static ResultSet rs=null;//조회결과 객체

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------------------------
		
		String job="SALESMAN";
		String job1="CLERK";
		String tablename="emp";
		
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
			//excute 할때 쿼리를 매개변수로 전달한다
//			st=conn.createStatement();
//			rs=st.executeQuery(sql);//물음표 모름
			
			//preparedStatement 객체는 생성될때
			//쿼리를 매개변수로 사용함
			//excute 수행할때 매개변수없음
			//cxcute 전에 ?에 대한 값 채워줘애함
			ps=conn.prepareStatement(sql);
			ps.setString(1, job);//SALESMAN 이 'SALESMAN'으로 들어감
			rs=ps.executeQuery();
			//-------------------------
			
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
