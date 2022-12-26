<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	// 한글처리
	request.setCharacterEncoding("utf-8");
	// 해당 컨텍스트 가져오기
	String home = request.getContextPath();
	
	// 세션 로그아웃 처리 = 파라미터 1 받아서 처리
	String logout = request.getParameter("logout"); // 1이 넘어옴
	if(logout != null) {
		session.setAttribute("id", null);
		session.setMaxInactiveInterval(0);
	}

	// 세션 로그인 처리
	String id = (String)session.getAttribute("id");
	if(id==null){
		id = "Guest";
	}
%>
            <div class="logo">
                <h1><a href="index.jsp">WEB JAVA</a></h1>
                <aside>
<%
	if(id.equals("Guest")){
%>
                    <strong><%=id %></strong>님 로그인중 &nbsp;
                    <button class="btn btn-primary" onclick="location.href='index.jsp?content=login.jsp'">
                    	로그인
                    </button>

<%		
	}else{
%>
			        <strong>${id }</strong>님 로그인중 &nbsp;
			        <button class="btn btn-primary" onclick="location.href='index.jsp?logout=1'">
			        	로그아웃
			        </button>
<%			        
	}
%>                
                </aside>
            </div>
            <nav class="gnb">
                <ul>
                    <li><a href="index.jsp?content=MainWebPage01.jsp">회원가입</a></li>
                    <li><a href="index.jsp?content=MainWebPage02.jsp">게시판</a></li>
                    <li><a href="IntranetCtrl.do">인트라넷</a></li>
                    <li><a href="index.jsp?content=MainWebPage04.jsp">로그인</a></li>
                </ul>
            </nav>