package com.bitacademy.emillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitacademy.emillist.vo.EmaillistVo;



public class EmaillistDao {

	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 클래스로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결
			String url = "jdbc:mariadb://192.168.0.150:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. statement준비
			String sql ="select no, first_name, last_name, email from emaillist order by no asc";
			pstmt = conn.prepareStatement(sql);
			// 4. 바인딩 
			
			// 5. statement실행
			rs = pstmt.executeQuery();
			
			// 5. 결과처리
			while(rs.next()) {
				Long no = rs.getLong(1); // DB는 1부터시작
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+ e);
		} catch (SQLException e) {
			System.out.println("Error: "+ e);
		} finally {// 6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void insert(EmaillistVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 클래스로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결
			String url = "jdbc:mariadb://192.168.0.150:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. statement준비
			String sql ="insert into emaillist values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 4. 바인딩 
			pstmt.setString(1,vo.getFirstName());
			pstmt.setString(2,vo.getLastName());
			pstmt.setString(3,vo.getEmail());
			// 5. statement실행
			rs = pstmt.executeQuery();
			
			// 6. 결과처리할게 있나 -> sql문 실행하면 끝인데
		    
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+ e);
		} catch (SQLException e) {
			System.out.println("Error: "+ e);
		} finally {// 6. 자원정리
			try {
				System.out.println("insert성공");
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 클래스로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결
			String url = "jdbc:mariadb://192.168.0.150:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. statement준비
			String sql ="delete from emaillist where email= ?";
			pstmt = conn.prepareStatement(sql);
			// 4. 바인딩 
			pstmt.setString(1, email);
			// 5. statement실행
			rs = pstmt.executeQuery();
			
			// 6. 결과처리할게 있나 -> sql문 실행하면 끝인데22
		    
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+ e);
		} catch (SQLException e) {
			System.out.println("Error: "+ e);
		} finally {// 6. 자원정리
			try {
				System.out.println("delete 성공");
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
