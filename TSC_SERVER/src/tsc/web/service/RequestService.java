package tsc.web.service;

import tsc.web.bean.ExamBean;
import tsc.web.bean.RequestBean;
import tsc.web.bean.request.CreateReqRequestBean;
import tsc.web.bean.request.CreateReqResponseBean;
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
			int examId = requestDao.addExam(exam.getCourseId(), exam.getIdentifier(), exam.getExamType(), exam.getBeginTime(), exam.getEndTime(), exam.getDuration(), exam.getTerm());
			if(examId>0){
				int requestId = requestDao.addRequest(examRequest.getUserId(), examId, examRequest.getStatus());
			}else{
				responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_ADD_FAIL);
			}
			
		}
		responseBean.setResult(FeedBackUtils.FB_CODE_REQUEST_ADD_FAIL);
				
		return responseBean;
		
	}
	
}
