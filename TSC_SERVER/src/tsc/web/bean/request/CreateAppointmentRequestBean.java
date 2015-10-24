package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.AppointmentBean;
import tsc.web.utils.FunUtils;
import tsc.web.utils.LogUtils;

public class CreateAppointmentRequestBean extends HttpRequestBean<AppointmentBean>{

	public static final String  PARA_EXAM_ID = "examId";
	public static final String  PARA_APPOINTMENT_STATUS = "status";
	public static final String  PARA_APPOINTMENT_STU_ID = "studentId";
	public static final String  PARA_APPOINTMENT_SEAT_ID = "seatId";
	public static final String  PARA_APPOINTMENT_STARTTIME = "startTime";
	public static final String  PARA_APPOINTMENT_ENDTIME = "endTime";
	
	
	
	
	AppointmentBean appointment;
	int userRole;
	
	public CreateAppointmentRequestBean(HttpServletRequest request) {
		super(request);
		appointment = new AppointmentBean();
		
	}

	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		if(appointment.getExamId()<=0){
			return false;
		}
		if(appointment.getSeatId()<=0){
			return false;
		}
		if(appointment.getStatus()<=0){
			return false;
		}
		if(appointment.getStudent()==null||appointment.getStudent().trim().length()==0){
			return false;
		}
		
		return true;
	}

	@Override
	public void parseData() {
		
		appointment.setExamId(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_ID)));
		appointment.setSeatId(TypeUtils.castToInt(mRequest.getParameter(PARA_APPOINTMENT_SEAT_ID)));
		appointment.setStatus(TypeUtils.castToInt(mRequest.getParameter(PARA_APPOINTMENT_STATUS)));
		appointment.setStudent(mRequest.getParameter(PARA_APPOINTMENT_STU_ID));
		appointment.setStartTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_APPOINTMENT_STARTTIME)));
		appointment.setEndTime(TypeUtils.castToTimestamp(mRequest.getParameter(PARA_APPOINTMENT_ENDTIME)));
		userRole = FunUtils.getUser(mRequest).getRole();

		
	}
	
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	@Override
	public AppointmentBean getObject() {
		
		
		
		return appointment;
	}

}
