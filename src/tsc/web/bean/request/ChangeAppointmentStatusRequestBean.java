package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;


public class ChangeAppointmentStatusRequestBean extends HttpRequestBean<Integer[]>{

	public static final String  PARA_APPOINTMENT_STATUS = "status";
	public static final String  PARA_APPOINTMENT_ID = "appointmentId";

	int status = 0;
	int appointmentId = 0;
	
	public ChangeAppointmentStatusRequestBean(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validData() {
		
		if(status<6&&status>1){
			return true;
		}
		return false;
	}

	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		status = Integer.valueOf(mRequest.getParameter(PARA_APPOINTMENT_STATUS));
		appointmentId = Integer.valueOf(mRequest.getParameter(PARA_APPOINTMENT_ID));
	}

	@Override
	public Integer[] getObject() {
		// TODO Auto-generated method stub
		return (new Integer[]{status,appointmentId});
	}

	
	
	
	
}
