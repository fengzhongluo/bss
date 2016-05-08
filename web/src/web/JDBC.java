package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	
	public static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	public static final String user="msg";
	public static final String password="msg";
	//创建连接
	public void conn(){
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
			ps=connection.prepareStatement("select * from msg");
			rs=ps.executeQuery();
			while(rs.next()){
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭连接
	public boolean close(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
		return false;
		}
		
		return true;
		
		
		
	}

}
