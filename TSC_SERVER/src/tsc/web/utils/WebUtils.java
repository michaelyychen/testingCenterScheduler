package tsc.web.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	                                                           //Customer.class
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		
		try{
			T bean = beanClass.newInstance();
		

			Map map = request.getParameterMap();
		
			BeanUtils.populate(bean, map);   
			
			return bean;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void forward(HttpServletRequest request,HttpServletResponse response,String uri) throws ServletException, IOException{
		request.getRequestDispatcher(uri).forward(request, response);
	}
	
	
	public static String paramatersToString(Object...objects){
		
		StringBuffer sb = new StringBuffer();
		for(Object obj : objects){
			if(sb.length()!=0){
				sb.append(",");
			}
			if(obj!=null)
			sb.append(obj.toString());
		}
		if(sb.length()==0){
			return "";
		}
		return sb.toString();
		
	}
}
