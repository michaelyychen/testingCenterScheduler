package tsc.web.service;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.request.CreateAppointmentRequestBean;
import tsc.web.bean.request.CreateAppointmentResponseBean;
import tsc.web.dao.AppointmentDao;
import tsc.web.dao.impl.AppointmentDataManager;
import tsc.web.utils.DaoFactory;
import tsc.web.utils.FeedBackUtils;

public class AppointmentService {

	AppointmentDao appointmentDao;
	AppointmentUtils appointmentUtils;
	
	public AppointmentService() {
		appointmentDao = DaoFactory.getInstance().createDao(AppointmentDao.class);
		appointmentUtils = new AppointmentUtils(appointmentDao);
	}
	
	
	public CreateAppointmentResponseBean createAppointment(CreateAppointmentRequestBean httpRequestBean){
		
		CreateAppointmentResponseBean mResponseBean = new CreateAppointmentResponseBean();
		
		AppointmentBean appointment = httpRequestBean.getObject();
		
		if(appointmentDao.getOverlappingTime(appointment.getStartTime(), 
				appointment.getEndTime(), 
				appointment.getStudent())==0){
			
			
			int id = appointmentDao.addAppointment(appointment.getExamId(), appointment.getStatus(), appointment.getStudent(), appointment.getSeatId());
			if(id>0){
				mResponseBean.set_id(id);
			}else{
				mResponseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_ADD_FAIL);
			}
			
		}else{
			
			mResponseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_OVERLAPPING);
		}
		
		return mResponseBean;
		
	}
}
