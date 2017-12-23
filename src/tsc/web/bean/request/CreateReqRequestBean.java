package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.ClassBean;
import tsc.web.bean.RequestBean;
import tsc.web.bean.UserBean;
import tsc.web.controller.UserController;
import tsc.web.utils.FunUtils;

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
		
		
		requestBean.getExam().setBeginTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_EXAM_BEGIN_TIME)));
		requestBean.getExam().setEndTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_EXAM_END_TIME)));
		requestBean.getExam().setDuration(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_DURATION)));
		requestBean.getExam().setExamType(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_TYPE)));
//		//requestBean.setUserId(TypeUtils.castToInt(mRequest.getParameter(PARA_USER_ID)));
//		HttpSession session = mRequest.getSession();
//		Object sesseionObj =  session.getAttribute(UserController.SESSION_USER);
//		if(sesseionObj instanceof UserBean){
//			UserBean user = (UserBean) sesseionObj;
//			requestBean.setUserId(TypeUtils.castToInt(user.get_id()));
//		}
		requestBean.getExam().setTerm(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_TERM)));
		requestBean.set_id(FunUtils.getUser(mRequest).get_id());
		requestBean.setStatus(TypeUtils.castToInt(mRequest.getParameter(PARA_REQUEST_STATUS)));
		requestBean.getExam().setExamNumber(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_NUMBER)));
		String courseJson = mRequest.getParameter(PARA_COURSE);
		if(courseJson != null && courseJson.trim().length() > 0){
			requestBean.setClassBean(JSON.parseObject(courseJson, ClassBean.class));
			requestBean.getExam().setClassId(requestBean.getClassBean().get_id());
		}
		requestBean.getExam().setIdentifier(examIdentifier());
	}
	
	private String examIdentifier() {
		// TODO Auto-generated method stub
		String classname = requestBean.getClassBean().getClassName();
		String examnumber = TypeUtils.castToString(requestBean.getExam().getExamNumber());
		String termnumber = TypeUtils.castToString(requestBean.getExam().getTerm());
		return classname + "_" + termnumber + "_" + examnumber;
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
