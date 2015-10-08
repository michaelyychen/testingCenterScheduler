package tsc.web.dao;

import java.util.List;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.SeatBean;

public interface AppointmentDao {

	int updateAppoinmentStatus(int status,int id);
	int addAppointment( int examId, int status,String stuId,int seatId);
	int deleteAppointment(String stuId,int appointmentId,int role);
	int updateAppointmentStatus(int status,int appointmentId);
	List<AppointmentBean> getAppointments(String stuId,int role);
	
	List<SeatBean> getAvaSeats(int examId,int role);
}
