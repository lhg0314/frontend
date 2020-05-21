package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	System.out.println("/hello-접속완료");
    	
    	//응답 데이터 형식 지정
    	resp.setContentType("text/html;charset=utf-8");
    	
    	//응답 출력 스트림
    	PrintWriter out=resp.getWriter();
    	
    	//응답 내용 츨력(html 형식)
    	out.append("<h1>하이하이</h1>");
    	out.append("<h3>잘되나여?</h3>");
	}


}
