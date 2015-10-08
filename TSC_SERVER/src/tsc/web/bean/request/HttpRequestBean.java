package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

public abstract class HttpRequestBean{

	protected HttpServletRequest mRequest;
	public HttpRequestBean(HttpServletRequest request) {
		
		mRequest = request;
		parseData();
	}
	
	
	public abstract boolean validDate();
	public abstract void parseData();

}
