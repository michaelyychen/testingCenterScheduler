package tsc.web.service;

import java.util.List;

import tsc.web.bean.ExamBean;
import tsc.web.bean.RequestBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.ChangeReqStatusRequestBean;
import tsc.web.bean.request.ChangeReqStatusResponseBean;
import tsc.web.bean.request.CreateReqRequestBean;
import tsc.web.bean.request.CreateReqResponseBean;
import tsc.web.bean.request.ViewReqRequestBean;
import tsc.web.bean.request.ViewReqResponseBean;
import tsc.web.dao.AppointmentDao;
import tsc.web.dao.RequestDao;
import tsc.web.utils.DaoFactory;
import tsc.web.utils.FeedBackUtils;

public class RequestService {

	RequestDao requestDao;
	
	public RequestService() {
		
		requestDao = DaoFactory.getInstance().createDao(RequestDao.class);
		
	}
	
	
	public CreateReqResponseBean addRequest(CreateReqRequestBean request){
		
		CreateReqResponseBean responseBean = new CreateReqResponseBean();
		RequestBean examRequest = request.getObject();
		ExamBean exam = examRequest.getExam();
		if(exam!=null){
		//	int examId = requestDao.addExam(exam.getCourseId(), exam.getExamIdentifier(),exam.getExamType(), exam.getBeginDate(), exam.getEndDate(), exam.getDuration(), exam.getTerm());
			int examId = requestDao.addExam(exam.getClassId(), exam.getIdentifier(), exam.getExamType(), exam.getBeginTime(), exam.getEndTime(), exam.getDuration(), examRequest.getClassBean().getTerm());
			if(examId>0){
				int requestId = requestDao.addRequest(examRequest.getUserId(), examId, examRequest.getStatus());
			}else{
				responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_ADD_FAIL);
			}
			
		}
		responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_ADD_FAIL);
				
		return responseBean;
		
	}


	public ViewReqResponseBean getRequestList(ViewReqRequestBean resquestBean) {
		// TODO Auto-generated method stub
		ViewReqResponseBean responseBean = new ViewReqResponseBean();
		try {
			int role = resquestBean.getRole();
			int userId = resquestBean.get_id();
			List<RequestBean> requests =  requestDao.getRequests(role, userId);
		} catch (Exception e) {
			responseBean.setResult(FeedBackUtils.FB_CODE_GLOBAL_EXCEPTION);
		}finally{
			
		}
		return responseBean;
	}


	public ChangeReqStatusResponseBean changeRequestStatus(ChangeReqStatusRequestBean requestBean, UserBean user) {
		// TODO Auto-generated method stub
		ChangeReqStatusResponseBean responseBean = new ChangeReqStatusResponseBean();
		if (RequestUtils.checkUpdateRequestStatusPermission(user.getRole(), requestBean.getStatus())) {
			int result = requestDao.updateRequestStatus(requestBean.get_id(), requestBean.getStatus());
			if (result <= 0) {
				responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_UPDATE_STATUS_FAIL);
			}
		}
		else {
			responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_NO_PERMISSION);
		}
		return responseBean;
	}
	
}
