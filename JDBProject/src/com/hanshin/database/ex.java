package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ex {

	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "112400ss");
			
			
			///////////////////////////////////
			//1. 현재 코드를 이용해서 database의 모든 데이터를 출력
			Statement st = con.createStatement();			
			String sql = "SELECT * FROM databasetest.member";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {	
				@SuppressWarnings("unused")
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String dept = rs.getString("dept");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				System.out.printf("id: %d, username: %s, dept: %s, birth: %s, email: %s, " + "\n", id, username, dept, birth, email);			}

			rs.close();
			st.close();
			////////////////////////////////////
//			// 2. INSERT INTO 를 이용해서 자신의 username/birth/depth/email 입력한 후 출력
//			Statement st = con.createStatement();
//			String sql = "INSERT INTO databasetest.member VALUES ('10', 'Won', 'France', '1986-07-14', 'gmail')";
//			st.executeUpdate(sql);
//			sql = "SELECT * FROM databasetest.member";
//			ResultSet rs = st.executeQuery(sql);
//
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String username = rs.getString("username");
//				String dept = rs.getString("dept");
//				String birth = rs.getString("birth");
//				String email = rs.getString("email");
//				System.out.printf("id: %d, username: %s, dept: %s, birth: %s, email: %s, " + "\n", id, username, dept, birth, email);//			}
//			
//			
//			rs.close();
//			st.close();
			////////////////////////////////////
			//3. dept가 computer인 사람들의 데이터를 출력: (데이터의 가공은 DBMS에게 맡기자)
//			Statement st = con.createStatement();
//			String sql = "SELECT * FROM databasetest.member WHERE dept = 'computer'";
//			ResultSet rs = st.executeQuery(sql);
//			
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String username = rs.getString("username");
//				String dept = rs.getString("dept");
//				String birth = rs.getString("birth");
//				String email = rs.getString("email");
//				System.out.printf("id: %d, username: %s, dept: %s, birth: %s, email: %s, " + "\n", id, username, dept, birth, email);
//			}
//			
//			rs.close();
//			st.close();
//			////////////////////////////////////
//			// 4. Statement를 PreparedStatement로 변경해서 row 1개 추가
//			String sql = "INSERT INTO databasetest.member VALUES (?, ?, ?, ?, ?)";
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, 11);
//			st.setString(2, "gam");
//			st.setString(3, "namu");
//			st.setString(4, "1900-02-05");
//			st.setString(5, "tree");
//			st.executeUpdate();
//
//			sql = "SELECT * FROM databasetest.member";
//			ResultSet rs = st.executeQuery(sql);
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String username = rs.getString("username");
//				String dept = rs.getString("dept");
//				String birth = rs.getString("birth");
//				String email = rs.getString("email");
//				System.out.printf("id: %d, username: %s, dept: %s, birth: %s, email: %s, " + "\n", id, username, dept, birth, email);
//			}
//			
//			rs.close();
//			st.close();
//			
//			/////////////////////////////////////
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
