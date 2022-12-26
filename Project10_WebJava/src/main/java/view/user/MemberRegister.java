package view.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.MemberDAO;
import biz.vo.UserBean;

@WebServlet("/MemberRegister.do")
public class MemberRegister extends HttpServlet {
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
		// 자바빈 사용
		UserBean ubean = new UserBean();
		// 폼 데이터 처리
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		ubean.setId(id);
		ubean.setPassword(password);
		ubean.setName(name);
		ubean.setRole(role);
		
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(ubean);
		
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
		
		
		
		
		
	}

}
