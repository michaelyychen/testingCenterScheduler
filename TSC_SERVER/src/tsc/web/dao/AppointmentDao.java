package tsc.web.dao;

import java.sql.Timestamp;
import java.util.List;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.AppointmentReminderBean;
import tsc.web.bean.ExamBean;
import tsc.web.bean.SeatBean;

public interface AppointmentDao {

	int updateAppoinmentStatus(int status,int id);
	int addAppointment( int examId, int status,String stuId,int seatId);
	int deleteAppointment(String stuId,int appointmentId,int role);
	int updateAppointmentStatus(int status,int appointmentId);
	List<AppointmentBean> getAppointments(String stuId,int role,int offset);
	
	List<SeatBean> getAvaSeats(int examId,int role);
	
	int getOverlappingTime(Timestamp start,Timestamp end,String student);
    List<ExamBean> getExams(String studentId, int role);
    List<ExamBean> getAdHocExams(String studentId, int role);
    List<AppointmentReminderBean> getReminders();
    
    
}
