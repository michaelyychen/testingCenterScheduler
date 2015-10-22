package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.RequestBean;

public class CreateReqRequestBean extends HttpRequestBean<RequestBean> {

	public static final String EXAM_IDENTIFIER = "examIdentifier";
	public static final String COURSE_NAME = "courseName";
	public static final String COURSE_ID = "courseId";
	
	
	private RequestBean requestBean;
	
	public CreateReqRequestBean(HttpServletRequest request) {
		super(request);
		requestBean = new RequestBean();
	}
	
	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		requestBean.getExam().setidentifier(mRequest.getParameter(EXAM_IDENTIFIER));
		requestBean.getExam().setCourseName(mRequest.getParameter(COURSE_NAME));
		requestBean.getExam().setCourseId(TypeUtils.castToInt(mRequest.getParameter(COURSE_ID)));
		requestBean.getExam().setBeginTime(beginTime);
		requestBean.getExam().setEndTime(endTime);
		requestBean.getExam().setDuration(duration);
		requestBean.getExam().setExamType(examType);
		requestBean.getExam().setTerm(term);
		
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
