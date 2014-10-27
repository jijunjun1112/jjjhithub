package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.domain.User;

public class Demo2 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
	
			//1.��������(�����Ƽ��ķ�ʽ)
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ�����ݿ������
			conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			
			//3.��ȡ���������ݿⷢ��sql����statement
			st = conn.createStatement();
			
			//4.�����ݿⷢsql,����ȡ����������resultset
			String sql = "select id,name,password,email,birthday from users";
			rs = st.executeQuery(sql);
			
			//5.ȡ�������������
			rs.afterLast();
			rs.previous();
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name=" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
			
		}finally{
		//6.�ر����ӣ��ͷ���Դ
			/*if(rs!=null){
				try{
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
	
			}
			if(st!=null){
				try{
					st.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}*/
			
			
			if(rs!=null){
				try{
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(st!=null){
						try{
							st.close();
						}catch (Exception e) {
							e.printStackTrace();
						}finally{
							if(conn!=null){
								try{
									conn.close();
								}catch (Exception e) {
									e.printStackTrace();
								}
								
							}
						}
						
					}
				}
			}
			
		}

	}

}
