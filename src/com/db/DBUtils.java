package com.db;



import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ�Ĳ��������࣬�����������ݵ�
 * @author Lz
 *
 */
public class DBUtils {
	
	private static Connection con = null ;
	
	public static Connection getConn(){
		if(con == null){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;databasename=dorm_wj" ;
				con = DriverManager.getConnection(url,"sa","123");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con ;
	}
}
