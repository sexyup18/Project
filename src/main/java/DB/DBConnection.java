package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			return DriverManager.getConnection(url,"system","qw1234");
		} catch (Exception e) {
			System.out.println("getConnection Exception - "+e.toString());
			System.out.println("DB Connection Fail");
			return null;
		}
	}//getConnection
		
	public static void close(ResultSet rs,PreparedStatement pst,Statement st,Connection cn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (st != null) {
				st.close();
			}
			if (cn != null) {
				cn.close();
			}
			
		} catch (Exception e) {
			System.out.println("close Exception => "+e.toString());
		}
	}//close()
}//DBConnection