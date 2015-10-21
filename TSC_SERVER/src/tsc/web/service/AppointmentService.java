package tsc.web.service;

import java.util.List;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.FeedBackBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.ChangeAppointmentStatusRequestBean;
import tsc.web.bean.request.ChangeAppointmentStatusResponseBean;
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


	public List<AppointmentBean> getAppointments(UserBean user) {
		
		return null;
	}


	public ChangeAppointmentStatusResponseBean changeAppointmentStatus(
			ChangeAppointmentStatusRequestBean requestBean,UserBean user) {
		
		ChangeAppointmentStatusResponseBean responseBean = new ChangeAppointmentStatusResponseBean();
		if(AppointmentUtils.checkUpdateAppointmentPermission(user.getRole(),requestBean.getObject()[0])){
			
			int result = appointmentDao.updateAppoinmentStatus(requestBean.getObject()[0], requestBean.getObject()[1]);
			if(result<=0){
				responseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_NO_PERMISSION);
			}else{
				responseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_UPDATE_STATUS_FAIL);
			}
		}else{
			responseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_NO_PERMISSION);
		}
		return responseBean;
	}



}
