package com.pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) throws Exception {
		// �л��������� ���α׷�(ver 0.20.0)
		/*
		 * 1.���� 2.�Է� 3.���� 4.���� 0.����>
		 */
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Properties props = new Properties();
		props.setProperty("user", "scott");
		props.setProperty("password", "tiger");

		Connection conn = null;
		Statement stmt = null;
		java.sql.ResultSet rs = null;

		int kor = 0;
		int eng = 0;
		int math = 0;
		int tot = kor + eng + math;
		double avg = Math.round(tot/3.0*100)/100;
		System.out.println("�л��������� ���α׷� (ver 0.20.0)");
		int choice = -1;
		boolean boo = true;
		while (boo) {
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.����> ");
			choice = sc.nextInt();
			switch (choice) {
			case 0: // ����
				System.out.println("���α׷��� �����մϴ�. \t �̿����ּż� �����մϴ�.");
				boo = false;
				sc.close();
				break;
			case 1: // ����

				break;
			case 2: // �Է�
				System.out.println("�л� ������ �Է��ϼ���");
				System.out.print("����> ");
				kor = sc.nextInt();
				System.out.print("����> ");
				eng = sc.nextInt();
				System.out.print("����> ");
				math =sc.nextInt();	
				

				String sql = "";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, props);
					stmt = conn.createStatement();

					while (rs.next()) {
						System.out.print(rs.getObject(1) + "\t");
						System.out.print(rs.getObject(2) + "\t");
						System.out.println(rs.getObject(3));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				break;
			case 3: // ����
				break;
			case 4: // ����
				break;
			}
		}

	}

}
