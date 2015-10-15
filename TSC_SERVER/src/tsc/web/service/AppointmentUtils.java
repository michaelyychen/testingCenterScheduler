package tsc.web.service;

import tsc.web.dao.AppointmentDao;

public class AppointmentUtils {

	AppointmentDao appointmentDao;
	
	public AppointmentUtils(AppointmentDao dao) {
		
		appointmentDao = dao;
		
	}
	
	public boolean seatAvailiability(int examId,int seatId){
		
		return true;
	}
	
}
