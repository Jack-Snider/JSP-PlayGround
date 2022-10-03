package jacksnider.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jacksnider.vo.JackSnider;

@SuppressWarnings("serial")
@WebServlet( "/jacksnider.do" )
public class JackSniderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println( "[ Jack Snider ] : 축하합니다! 서블릿을 호출하는데 성공하셨습니다.!" );
		
		JackSnider jack = new JackSnider();
		
		jack.setName( "Jack Snider" );
		jack.setAge( 28 );
		jack.setJob( "Developer" );
		
		resp.setIntHeader("Refresh", 1);
		
		// application/json;charset=utf-8 : json형태로 보내기
		// 객체로 보내려면 json데이터로 만드는게 좋다..
		
		// text/html;charset=UTF-8 : text형태로 보내기
		resp.setContentType("application/json;charset=utf-8");
		
		
		String json = "{\"name\":" + "\"" +jack.getName() + "\"" + ", \"age\":" + "\"" + jack.getAge() + "\"" + ", \"job\":" + "\"" + jack.getJob() + "\"" + "}"; 
				
		System.out.println( json );
		
		PrintWriter out = resp.getWriter();
		out.print( json );
		
		
		
		
	}
	
}
