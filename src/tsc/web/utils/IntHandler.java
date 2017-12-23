package tsc.web.utils;

import java.sql.ResultSet;

public class IntHandler implements ResultSetHandler {

	public Object handler(ResultSet rs) {
		try{
			if(rs.next()){
				return rs.getInt(1);
			}
			return 0;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
