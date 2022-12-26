package view.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginCtrl.do")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);		
	}
	
	// get, post 처리
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 데이터 처리
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 세션에 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		
		// 세션 시간설정
		session.setMaxInactiveInterval(60*20);
		
		if(id != null) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("index.jsp?content=login.jsp");
		}
		
		
		
		// (참고) 로그인 조건에 따른 분기
		/*
		 * String id2 = (String)session.getAttribute("id"); if(id2.equals("admin")) {
		 * response.sendRedirect("Admin 페이지 이동"); }else {
		 * response.sendRedirect("일반유저 페이지 이동"); }
		 */
		
		
		
		
		
		
		
		
	}

}
