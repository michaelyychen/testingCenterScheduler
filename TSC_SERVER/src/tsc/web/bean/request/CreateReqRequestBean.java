package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import tsc.web.bean.RequestBean;

public class CreateReqRequestBean extends HttpRequestBean<RequestBean> {

	public static final String EXAM_IDENTIFIER = "examIdentifier";
	private RequestBean requestBean;
	
	public CreateReqRequestBean(HttpServletRequest request) {
		super(request);
		requestBean = new RequestBean();
	}
	
	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		requestBean.getExam().setExamIdentifier(mRequest.getParameter(EXAM_IDENTIFIER));
		
	}
	@Override
	public RequestBean getObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
