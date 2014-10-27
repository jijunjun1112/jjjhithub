package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@192.168.1.59:1521:rentvilla";
		String username = "scott";
		String password = "Jun13676830606";
		
		//1.��������oracle.jdbc.driver.OracleDriver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		//2.��ȡ�����ݿ������
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.��ȡ���������ݿⷢ��sql����statement
		Statement st = conn.createStatement();
		
		//4.�����ݿⷢsql,����ȡ����������resultset
		String sql = "select id,name,password,email,birthday from users";
		ResultSet rs = st.executeQuery(sql);
		
		//5.ȡ�������������
		while(rs.next()){
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name=" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}
		
		//6.�ر����ӣ��ͷ���Դ
		rs.close();
		st.close();
		conn.close();

	}

}
