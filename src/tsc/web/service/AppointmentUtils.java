package tsc.web.service;

import tsc.web.dao.AppointmentDao;

public class AppointmentUtils {
	
	public static final int  APP_STATUS_PENDING = 1;
	public static final int  APP_STATUS_APPROVE = 2;
	public static final int  APP_STATUS_DENY = 3;
	public static final int  APP_STATUS_CHECKEDIN = 4;
	public static final int  APP_STATUS_ABSENT = 5;
	public static final int  APP_STATUS_SUPERFLOUS = 6;
	public static final int  APP_STATUS_CANEL = 7;


	AppointmentDao appointmentDao;
	
	public AppointmentUtils(AppointmentDao dao) {
		
		appointmentDao = dao;
		
	}
	
	public boolean seatAvailiability(int examId,int seatId){
		
		return true;
	}

	public static boolean checkUpdateAppointmentPermission(int role,int status) {
		
		if(role != 3){// if the user is not admin
			
			if(status!=APP_STATUS_CANEL){//if the user is student, he only can cancel the appointment
				return false;
			}
		}
		
		return true;
	}
	
}
