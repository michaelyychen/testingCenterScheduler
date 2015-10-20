package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

public abstract class HttpRequestBean<T>{

	protected HttpServletRequest mRequest;
	public HttpRequestBean(HttpServletRequest request) {
		
		mRequest = request;
		parseData();
	}
	
	
	public abstract boolean validData();
	public abstract void parseData();
	public abstract T getObject();
}
