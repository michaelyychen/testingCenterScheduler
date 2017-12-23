package tsc.web.utils;

public class DBUtils {


	public static final String DB_OPERATION_DELETE = "DELETE";
	public static final String DB_OPERATION_ADD = "ADD";
	public static final String DB_OPERATION_UPDATE = "UPDATE";
	public static final String DB_OPERATION_QUERY = "QUERY";
	
	
	public static String convertToText(String sql,Object... values){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SQL : ").append(sql);
		
		if(values!=null&&values.length>0){
			sb.append(" value(");
			for(Object value : values){
				if(value!=null){
					sb.append(value.toString()).append(",");
				}
			}
			sb.append(");");
		}
		
		return sb.toString();
	
	}
		
	
}
