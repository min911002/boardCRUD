package biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import biz.vo.UserBean;

public class MemberDAO {
	// 커넥션 풀 사용 오라클 DB 접속 메서드
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// DB 접속 메서드
	public void dbConn() {
		try {
			Context initctx = new InitialContext();
			System.out.println("1.Context 생성 성공!!");
			Context envctx = (Context)initctx.lookup("java:comp/env");
			System.out.println("2.Context 환경생성 성공!!");
			DataSource ds = (DataSource)envctx.lookup("jdbc/pool");
			System.out.println("3.DataSource 찾기 성공!!");
			conn = ds.getConnection();
			System.out.println("4. DB접속 성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 메서드
	public void insertMember(UserBean ubean) {
		dbConn();
		try {
			String sql = "insert into web_users(seq,id,password,name,role) "
					+ "values((select nvl(max(seq),0)+1 from web_users),?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ubean.getId());
			pstmt.setString(2, ubean.getPassword());
			pstmt.setString(3, ubean.getName());
			pstmt.setString(4, ubean.getRole());
			
			pstmt.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
