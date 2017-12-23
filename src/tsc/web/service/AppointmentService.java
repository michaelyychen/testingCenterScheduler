package tsc.web.service;

import java.util.List;

import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.AppointmentReminderBean;
import tsc.web.bean.ExamBean;
import tsc.web.bean.FeedBackBean;
import tsc.web.bean.SeatBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.ChangeAppointmentStatusRequestBean;
import tsc.web.bean.request.ChangeAppointmentStatusResponseBean;
import tsc.web.bean.request.CreateAppointmentRequestBean;
import tsc.web.bean.request.CreateAppointmentResponseBean;
import tsc.web.bean.request.ViewAppointmentRequestBean;
import tsc.web.bean.request.ViewAppointmentResponseBean;
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
			 List<SeatBean> seats = appointmentDao.getAvaSeats(appointment.getExamId(), 1);
			
			 if(httpRequestBean.getUserRole()==1||appointment.getSeatId()==0){
				
				 if(seats==null||seats.size()==0){
					 mResponseBean.setResult(FeedBackUtils.FB_CODE_NO_SEATS_AVA);
					 return mResponseBean;
				 }else{
					 appointment.setSeatId(seats.get(0).get_id()); // return adjacent seat
				 }
				
			 }else{
				 //check seat availibility
				 if(!checkSeatIsAva(appointment, seats)){
					 mResponseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_SEAT_YOUR_CHOOSE_IS_NOT_AVA_ANY_MORE);
					 return mResponseBean;
				 }
				 
			 }
			 
			
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


	private boolean checkSeatIsAva(AppointmentBean appointment,
			List<SeatBean> seats) {
		boolean checkSeat = false;
		 for(SeatBean seat : seats){
			 if(seat.get_id()==appointment.getSeatId()){
				 checkSeat = true;
				 break;
			 }
		 }
		 return  checkSeat;
	}



		public ViewAppointmentResponseBean getAppointments(UserBean user, ViewAppointmentRequestBean requestBean) {
			// TODO Auto-generated method stub
			ViewAppointmentResponseBean responseBean = new ViewAppointmentResponseBean();
			try {
				int role = user.getRole();
				String ID = user.getUserId();
				int offset = requestBean.getObject();
				List<AppointmentBean> appointments = appointmentDao.getAppointments(ID, role, offset);
				responseBean.setAppointments(appointments);
			} catch (Exception e) {
				responseBean.setResult(FeedBackUtils.FB_CODE_GLOBAL_EXCEPTION);
			}finally{
				
			}
			return responseBean;
		}


	public ChangeAppointmentStatusResponseBean changeAppointmentStatus(
			ChangeAppointmentStatusRequestBean requestBean,UserBean user) {
		
		ChangeAppointmentStatusResponseBean responseBean = new ChangeAppointmentStatusResponseBean();
		if(AppointmentUtils.checkUpdateAppointmentPermission(user.getRole(),requestBean.getObject()[0])){
			
			int result = appointmentDao.updateAppoinmentStatus(requestBean.getObject()[0], requestBean.getObject()[1]);
			if(result<=0){
				responseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_UPDATE_STATUS_FAIL);
			}
		}else{
			responseBean.setResult(FeedBackUtils.FB_CODE_APPOINTMENT_NO_PERMISSION);
		}
		return responseBean;
	}
	
	public List<SeatBean> getAvaSeats(int examId,int role){
		
		return appointmentDao.getAvaSeats(examId, role);
		
	}


	public List<ExamBean> getExams(UserBean user) {
		// TODO Auto-generated method stub
		 List<ExamBean> exams = null;
		if(user!=null){
			exams = appointmentDao.getExams(user.getUserId(), user.getRole());
		}
		return exams;
	}
	
	public List<AppointmentReminderBean> getReminders(){
		
		return appointmentDao.getReminders();
		
	}
	
	
	
	
	



}
