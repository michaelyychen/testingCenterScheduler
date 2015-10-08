package tsc.web.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {


	private static DataSource ds = null;
	static{
		ds = new ComboPooledDataSource();
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static DataSource getDataSource() throws SQLException{
		return ds;
	}
	public static void free(Connection conn,Statement ps,ResultSet rs){
		
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e) {}
			rs = null;   
		}
		if(ps!=null){
			try{
				ps.close();
			}catch (Exception e) {}
			ps = null;
		}
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {}
			conn = null;
		}	
	}
	
	public static int update(String sql,Object params[]) throws SQLException{
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			return ps.executeUpdate();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		
	}

	public static Object query(String sql,Object params[],ResultSetHandler rsh) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();
			return rsh.handler(rs);
			
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
	}
	
		public static Object query(String sql,List params,ResultSetHandler rsh) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				conn = JdbcUtils.getConnection();
				ps = conn.prepareStatement(sql);
				for(int i=0;i<params.size();i++){
					ps.setObject(i+1, params.get(i));
				}
				rs = ps.executeQuery();
				return rsh.handler(rs);
				
			}finally{
				JdbcUtils.free(conn, ps, rs);
			}
		}
		
		public static Object queryByProc(String sql,List params,ResultSetHandler rsh){
			
			Connection conn = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			  try {
					conn = JdbcUtils.getConnection();
				cstmt = conn.prepareCall(sql);
				if(params!=null){
					for(int i=0;i<params.size();i++){
						cstmt.setObject(i+1, params.get(i));
					}
				}
				rs = cstmt.executeQuery();
				return rsh.handler(rs);
			} catch (SQLException e) {
				LogUtils.outputError("JdbcUtils", "queryByProc", e.getMessage());
			}finally{
				JdbcUtils.free(conn, cstmt, rs);
			}
			return null;
		}
		
		public static int updateByProc(String sql,List params){
			
			Connection conn = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			  try {
				conn = JdbcUtils.getConnection();
				cstmt = conn.prepareCall(sql);
				for(int i=0;i<params.size();i++){
					cstmt.setObject(i+1, params.get(i));
				}
				return  cstmt.executeUpdate();
			} catch (SQLException e) {
				LogUtils.outputError("JdbcUtils", "queryByProc", e.getMessage());
				return 0;
			}finally{
				JdbcUtils.free(conn, cstmt, rs);
			}
			  
		}
}

