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
			////1) Java ������Ʈ���� Statement�� �̿��Ͽ� addressbook �̶�� table �����
			String sql = "CREATE TABLE addressbook ("
					+ "id INT NOT NULL Primary key, "
					+ "name VARCHAR(45), "
					+ "tel VARCHAR(45), "
					+ "email VARCHAR(60), "
					+ "address VARCHAR(60))";
			st.executeUpdate(sql);
			
			
			////2) ������ ������ addressbook table�� PreparedStatement�� �̿��Ͽ� 5���� ������ set (��)�� �Է��ϱ�
			//- addressbook�� ��� �����͸� Statement�� �̿��ؼ� ��ȸ�Ͽ� eclipse�� console���� �� �� �ֵ��� �ݺ��� �� System.out.printf ����
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
			
			
			////3) 2)�� �ڵ� ���� PreparedStatement �̿��Ͽ� 5���� ���� email�� �������� @naver.com���� UPDATE ����
			//- addressbook�� ��� �����͸� Statement�� �̿��ؼ� ��ȸ�Ͽ� eclipse�� console���� �� �� �ֵ��� �ݺ��� �� System.out.printf ����
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
			
			
			////4) 3)�� �ڵ� ���� Statement�� �̿��Ͽ� ���� 2���� ���� ����� �ڵ� ����
			//- addressbook�� ��� �����͸� Statement�� �̿��ؼ� ��ȸ�Ͽ� eclipse�� console���� �� �� �ֵ��� �ݺ��� �� System.out.printf ����
//			int i = 0;	//id ����
//			int n = 2;	//������ �� ����
//			int idDelete[] = new int[n];	//������ ���� id�� ������ �迭
//			
//			String sql = "SELECT * FROM databasetest.addressbook";
//			ResultSet rs = st.executeQuery(sql);
//
//			//idDelete �迭�� ������ ���� id �ֱ�
//			while(rs.next()) {
//				idDelete[i] = rs.getInt("id");
//				i++;
//				if(i == n)
//					i = 0;
//			}
//			
//			//idDelete �迭�� �̿��Ͽ� n���� �� ����
//			for(int j = 0; j < n; j++) {
//				sql = "DELETE FROM databasetest.addressbook WHERE id = " + idDelete[j];
//				st.executeUpdate(sql);
//			}
//			
//			//��� ���
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
