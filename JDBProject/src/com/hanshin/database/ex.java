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
			//1. ���� �ڵ带 �̿��ؼ� database�� ��� �����͸� ���
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
//			// 2. INSERT INTO �� �̿��ؼ� �ڽ��� username/birth/depth/email �Է��� �� ���
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
			//3. dept�� computer�� ������� �����͸� ���: (�������� ������ DBMS���� �ñ���)
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
//			// 4. Statement�� PreparedStatement�� �����ؼ� row 1�� �߰�
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
