package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.CourseBean;
import tsc.web.bean.RequestBean;

public class CreateReqRequestBean extends HttpRequestBean<RequestBean> {

	public static final String PARA_EXAM_IDENTIFIER = "examIdentifier";
	public static final String PARA_COURSE_NAME = "courseName";
	public static final String PARA_COURSE_ID = "courseId";
	public static final String PARA_EXAM_BEGIN_TIME = "examBeginTime";
	public static final String PARA_EXAM_END_TIME = "examEndTime";
	public static final String PARA_EXAM_DURATION = "duration";
	public static final String PARA_EXAM_TYPE = "examtype";
	public static final String PARA_EXAM_TERM = "examTerm";
	public static final String PARA_USER_ID = "userId";
	public static final String PARA_REQUEST_STATUS = "requestStatus";
	public static final String PARA_COURSE = "course";
	public static final String PARA_EXAM_NUMBER = "examNumber";
	
	private RequestBean requestBean;
	
	public CreateReqRequestBean(HttpServletRequest request) {
		super(request);
		requestBean = new RequestBean();
	}
	
	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		requestBean.getExam().setIdentifier(examIdentifier());
		
		requestBean.getExam().setBeginTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_EXAM_BEGIN_TIME)));
		requestBean.getExam().setEndTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_EXAM_END_TIME)));
		requestBean.getExam().setDuration(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_DURATION)));
		requestBean.getExam().setExamType(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_TYPE)));
		requestBean.setUserId(TypeUtils.castToInt(mRequest.getParameter(PARA_USER_ID)));
		requestBean.setStatus(TypeUtils.castToInt(mRequest.getParameter(PARA_REQUEST_STATUS)));
		requestBean.getExam().setExamNumber(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_NUMBER)));
		String courseJson = mRequest.getParameter(PARA_COURSE);
		if(courseJson != null && courseJson.trim().length() > 0){
			requestBean.setCourse(JSON.parseObject(courseJson, CourseBean.class));
			requestBean.getExam().setCourseId(requestBean.getCourse().get_id());
		}
	}
	
	private String examIdentifier() {
		// TODO Auto-generated method stub
		String coursename = requestBean.getCourse().getCourseIdentifier();
		String examnumber = TypeUtils.castToString(requestBean.getExam().getExamNumber());
		return coursename + "_0" + examnumber;
	}

	@Override
	public RequestBean getObject() {
		// TODO Auto-generated method stub
		return requestBean;
	}
	
	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		if(requestBean.getUserId() < 0  ){
			return false;
		}
		if(requestBean.getExam().getDuration() < 0 ){
			return false;
		}
		int minutes = requestBean.getExam().getBeginTime().getMinutes();
		int seconds = requestBean.getExam().getBeginTime().getSeconds();
		if((minutes != 0 && minutes != 30) ||(seconds != 0)  ){
			return false;
		}
		minutes = requestBean.getExam().getEndTime().getMinutes();
		seconds = requestBean.getExam().getEndTime().getSeconds();
		if((minutes != 0 && minutes != 30) ||(seconds != 0)  ){
			return false;
		}
		
		
		return true;
	}
	

}