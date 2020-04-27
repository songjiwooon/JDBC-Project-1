package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCprocet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";
		
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "112400ss");

			Statement st = con.createStatement();	
			////1) Java 프로젝트에서 Statement를 이용하여 addressbook 이라는 table 만들기
			String sql = "CREATE TABLE addressbook ("
					+ "id INT NOT NULL Primary key, "
					+ "name VARCHAR(45), "
					+ "tel VARCHAR(45), "
					+ "email VARCHAR(60), "
					+ "address VARCHAR(60))";
			st.executeUpdate(sql);
			
			
			////2) 위에서 생성한 addressbook table에 PreparedStatement를 이용하여 5개의 데이터 set (행)을 입력하기
			//- addressbook의 모든 데이터를 Statement를 이용해서 조회하여 eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현
//			String sql = "INSERT INTO databasetest.addressbook VALUES (?, ?, ?, ?, ?)";
//			PreparedStatement pst = con.prepareStatement(sql);
//			pst.setInt(1, 5);
//			pst.setString(2, "Ji");
//			pst.setString(3, "010-5555-5555");
//			pst.setString(4, "daum");
//			pst.setString(5, "Jeju-do");
//			pst.executeUpdate();
//			
//			sql = "SELECT * FROM databasetest.addressbook";
//			ResultSet rs = st.executeQuery(sql);
//			
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String tel = rs.getString("tel");
//				String email = rs.getString("email");
//				String address = rs.getString("address");
//				System.out.printf("id: %d, name: %s, tel: %s, email: %s, address: %s, " + "\n", id, name, tel, email, address);
//			}
//			rs.close();
//			pst.close();
			
			
			////3) 2)번 코드 이후 PreparedStatement 이용하여 5개의 열의 email의 도메인을 @naver.com으로 UPDATE 수행
			//- addressbook의 모든 데이터를 Statement를 이용해서 조회하여 eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현
//			String sql = "SELECT * FROM databasetest.addressbook";
//			PreparedStatement pst = null;
//			ResultSet rs = st.executeQuery(sql);
//			int i = 1;
//			
//			while(rs.next()) {
//				String emailbak = rs.getString("email");
//				
//				sql = "update addressbook Set email = ? WHERE id = ?";
//				pst = con.prepareStatement(sql);
//				
//				pst.setString(1,emailbak+"@naver.com");
//				pst.setInt(2, rs.getInt("id"));
//				pst.executeUpdate();
//			}
//			
//			sql = "SELECT * FROM databasetest.addressbook";
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String tel = rs.getString("tel");
//				String email = rs.getString("email");
//				String address = rs.getString("address");
//				System.out.printf("id: %d, name: %s, tel: %s, email: %s, address: %s, " + "\n", id, name, tel, email, address);
//			}
//			
//			pst.close();
//			rs.close();
			
			
			////4) 3)번 코드 이후 Statement를 이용하여 하위 2개의 행을 지우는 코드 구현
			//- addressbook의 모든 데이터를 Statement를 이용해서 조회하여 eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현
//			int i = 0;	//id 변수
//			int n = 2;	//제거할 행 개수
//			int idDelete[] = new int[n];	//제거할 행의 id를 저장할 배열
//			
//			String sql = "SELECT * FROM databasetest.addressbook";
//			ResultSet rs = st.executeQuery(sql);
//
//			//idDelete 배열에 제거할 행의 id 넣기
//			while(rs.next()) {
//				idDelete[i] = rs.getInt("id");
//				i++;
//				if(i == n)
//					i = 0;
//			}
//			
//			//idDelete 배열을 이용하여 n개의 행 제거
//			for(int j = 0; j < n; j++) {
//				sql = "DELETE FROM databasetest.addressbook WHERE id = " + idDelete[j];
//				st.executeUpdate(sql);
//			}
//			
//			//결과 출력
//			sql = "SELECT * FROM databasetest.addressbook";
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()) {	
//				@SuppressWarnings("unused")
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String tel = rs.getString("tel");
//				String email = rs.getString("email");
//				String address = rs.getString("address");
//				System.out.printf("id: %d, name: %s, tel: %s, email: %s, address: %s, " + "\n", id, name, tel, email, address);
//			}	
//
//			rs.close();
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
