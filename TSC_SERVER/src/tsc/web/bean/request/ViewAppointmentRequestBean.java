package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.AppointmentBean;

public class ViewAppointmentRequestBean extends HttpRequestBean<Integer> {

	public static final String PARA_APPOINTMENT_PAGENUM = "pageNumber";
	private int pageNumber;
	
	private final int pagesize = 15;
	
	public ViewAppointmentRequestBean(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		super(request);
		
	}

	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		if(pageNumber > 0) return true;
		return false;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		pageNumber = TypeUtils.castToInt(mRequest.getParameter(PARA_APPOINTMENT_PAGENUM));
	}

	@Override
	public Integer getObject() {
		
		return (pageNumber -1) * pagesize;
	}
}