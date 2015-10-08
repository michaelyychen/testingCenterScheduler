package tsc.web.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public class BeanListHandler implements ResultSetHandler {

	private Class beanClazz;
	public BeanListHandler(Class beanClazz){
		this.beanClazz = beanClazz;
	
	}
	
	
	public Object handler(ResultSet rs) {
		List list = new ArrayList();
		try{
			while(rs.next()){
				Object bean = beanClazz.newInstance();
				ResultSetMetaData meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();			
				for(int i=0;i<columnCount;i++){
					String columnName = meta.getColumnName(i+1);  //id 
					Object columnValue = rs.getObject(columnName); //1
					try{
						PropertyDescriptor pd = new PropertyDescriptor(columnName,bean.getClass());
						Method method = pd.getWriteMethod();
						method.invoke(bean, columnValue);
					}catch (Exception e) {
						continue;
					}
				}
				list.add(bean);
			}
			return list;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
