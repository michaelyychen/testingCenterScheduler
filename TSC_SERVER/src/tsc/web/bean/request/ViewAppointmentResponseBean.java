package tsc.web.bean.request;

import java.util.List;

import tsc.web.bean.AppointmentBean;

public class ViewAppointmentResponseBean extends HttpResponseBean {

	private List<AppointmentBean> appointments;
	
	public ViewAppointmentResponseBean() {
		// TODO Auto-generated constructor stub
		appointments = null;
	}
	
	
	public void setAppointments(List<AppointmentBean> newappointments) {
		// TODO Auto-generated method stub
		appointments = newappointments;
		
	}

	public List<AppointmentBean> getAppointments() {
		return appointments;
	}
	
}
