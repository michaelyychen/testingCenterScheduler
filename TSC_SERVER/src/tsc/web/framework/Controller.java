package tsc.web.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public void exec(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public void errorPage(HttpServletRequest request,HttpServletResponse response,String message) throws Exception;
	public void webPageResponse(HttpServletRequest request, HttpServletResponse response,String path)throws Exception;
	public void jsonDataResponse();
}
