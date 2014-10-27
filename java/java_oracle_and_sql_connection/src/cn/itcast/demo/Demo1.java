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
		
		//1.加载驱动oracle.jdbc.driver.OracleDriver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		//2.获取与数据库的链接
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.获取用于向数据库发送sql语句的statement
		Statement st = conn.createStatement();
		
		//4.向数据库发sql,并获取代表结果集的resultset
		String sql = "select id,name,password,email,birthday from users";
		ResultSet rs = st.executeQuery(sql);
		
		//5.取出结果集的数据
		while(rs.next()){
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name=" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}
		
		//6.关闭链接，释放资源
		rs.close();
		st.close();
		conn.close();

	}

}
