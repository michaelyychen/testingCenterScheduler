package tsc.web.bean.request;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

import javafx.scene.input.DataFormat;
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

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd kk：mm:ss");
	
	AppointmentBean appointment;
	int userRole;
	
	public CreateAppointmentRequestBean(HttpServletRequest request) {
		super(request);
			
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
		// admin don't indicate stu ID, comment out
		if(appointment.getStudent()==null||appointment.getStudent().trim().length()==0){
			return false;
		}
		
		return true;
	}

	@Override
	public void parseData() {
		try {
			appointment = new AppointmentBean();
			appointment.setExamId(TypeUtils.castToInt(mRequest.getParameter(PARA_EXAM_ID)));
			appointment.setSeatId(TypeUtils.castToInt(mRequest.getParameter(PARA_APPOINTMENT_SEAT_ID)));
			appointment.setStatus(TypeUtils.castToInt(mRequest.getParameter(PARA_APPOINTMENT_STATUS)));
			appointment.setStudent(mRequest.getParameter(PARA_APPOINTMENT_STU_ID));
			Date startDate = df.parse(mRequest.getParameter(PARA_APPOINTMENT_STARTTIME));
			Date endDate = df.parse(mRequest.getParameter(PARA_APPOINTMENT_ENDTIME));
			appointment.setStartTime(new Timestamp(startDate.getTime()));
			appointment.setEndTime(new Timestamp(endDate.getTime()));
				
			
			userRole = FunUtils.getUser(mRequest).getRole();
		} catch (Exception e) {
			LogUtils.outputError("CreateAppointmentRequestBean", "parseData", e.getMessage());
		}

		
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
