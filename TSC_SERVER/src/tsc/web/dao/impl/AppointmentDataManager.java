package tsc.web.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.AppointmentReminderBean;
import tsc.web.bean.ExamBean;
import tsc.web.bean.SeatBean;
import tsc.web.dao.AppointmentDao;
import tsc.web.utils.BeanListHandler;
import tsc.web.utils.DBUtils;
import tsc.web.utils.IntHandler;
import tsc.web.utils.JdbcUtils;
import tsc.web.utils.LogUtils;

public class AppointmentDataManager implements AppointmentDao{

	
	private final String CLASS_NAME = "AppointmentDataManager";
	
	@Override
	public int updateAppoinmentStatus(int status, int id) {
	
	
		String sql = "{call change_appointment_status(?,?)}";
		List params = new ArrayList();
		params.add(status);
		params.add(id);
		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "updateAppoinmentStatus", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "updateAppoinmentStatus", DBUtils.convertToText(sql,status,id));
			return result;
		}

	}

	@Override
	public int addAppointment(int examId, int status, String stuId, int seatId) {
		String sql = "{call add_appointment(?,?,?,?)}";
		List params = new ArrayList();
		params.add(examId);
		params.add(status);
		params.add(stuId);
		params.add(seatId);

		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addAppointment", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addAppointment", DBUtils.convertToText(sql, examId,status,stuId,seatId));
			return result;
		}
		
	}

	@Override
	public List<SeatBean> getAvaSeats(int examId, int role) {
		String sql = "{call get_ava_seats(?,?)}";
		List params = new ArrayList();
		params.add(examId);
		params.add(role);
		List<SeatBean> result = null;
		try {
			result = (List<SeatBean>) JdbcUtils.queryByProc(sql,params,new BeanListHandler(SeatBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "getAvaSeats", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "getAvaSeats", DBUtils.convertToText(sql, examId,examId,role));
			return result;
		}
		
	}

	@Override
	public int deleteAppointment(String stuId, int appointmentId, int role) {
		String sql = "{call delete_appointment(?,?,?)}";
		List params = new ArrayList();
		params.add(stuId);
		params.add(appointmentId);
		params.add(role);
		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "deleteAppointment", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "deleteAppointment", DBUtils.convertToText(sql, stuId,appointmentId,role));
			return result;
		}
	}

	@Override
	public int updateAppointmentStatus(int status, int appointmentId) {
		
		String sql = "{call change_appointment_status(?,?)}";
		List params = new ArrayList();
		params.add(status);
		params.add(appointmentId);
		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "updateAppointmentStatus", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "updateAppointmentStatus", DBUtils.convertToText(sql, status,appointmentId));
			return result;
		}
	}

	@Override
	public List<AppointmentBean> getAppointments(String stuId,int role,int offset) {
		String sql = "{call get_appointments(?,?,?)}";
		List params = new ArrayList();
		params.add(stuId);
		params.add(role);
		params.add(offset);
		List<AppointmentBean> result = null;
		try {
			result = (List<AppointmentBean>) JdbcUtils.queryByProc(sql,params,new BeanListHandler(AppointmentBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "getAppointments", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "getAppointments", DBUtils.convertToText(sql,stuId,role));
			return result;
		}
	}



	@Override
	public int getOverlappingTime(Timestamp start, Timestamp end, String student) {
		String sql = "{call check_time(?,?,?)}";
		List params = new ArrayList();
		params.add(start);
		params.add(end);
		params.add(student);
		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "check_time", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "check_time", DBUtils.convertToText(sql, start,end,student));
			return result;
		}
	}
	
	
	
	@Override
	public List<ExamBean> getExams(String studentId, int role) {
		String sql = "{call get_student_exams(?,?)}";
		List params = new ArrayList();
		params.add(studentId);
		params.add(role);
		List<ExamBean> result = null;
		try {
			result = (List<ExamBean>) JdbcUtils.queryByProc(sql,params,new BeanListHandler(ExamBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "getExams", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "getExams", DBUtils.convertToText(sql, studentId,role));
		}
		
		
		//get adhoc exam
		result.addAll(getAdHocExams(studentId, role));
		
		return result;
	}

	@Override
	public List<ExamBean> getAdHocExams(String studentId, int role) {
		String sql = "{call get_adhoc_exam(?,?)}";
		List params = new ArrayList();
		params.add(studentId);
		params.add(role);
		List<ExamBean> result = null;
		try {
			result = (List<ExamBean>) JdbcUtils.queryByProc(sql,params,new BeanListHandler(ExamBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "getAdHocExams", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "getAdHocExams", DBUtils.convertToText(sql, studentId,role));
		}
		
		return result;
	}

	@Override
	public List<AppointmentReminderBean> getReminders() {
		String sql = "{call getReminders()}";
		List params = new ArrayList();
		List<AppointmentReminderBean> result = null;
		try {
			result = (List<AppointmentReminderBean>) JdbcUtils.queryByProc(sql,params,new BeanListHandler(AppointmentReminderBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "getReminders", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "getReminders", DBUtils.convertToText(sql));
		}
		
		return result;
	}
	


}
