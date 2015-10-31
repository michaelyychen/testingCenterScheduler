package tsc.web.bean;

import java.sql.Timestamp;

public class AppointmentReminderBean {

	private String lastName;
	private String firstName;
	
	private String email;
	private String exam;
	private String className;
	private Timestamp startTime;
	private String seatNumber;
	
	public AppointmentReminderBean() {
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return "sunyu90@hotmail.com";
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getEmailContent(){
		
		StringBuffer sb = new StringBuffer("Dear ").append(lastName).append(":<Br><br>You have a upcoming exam, the information as blow:<br><br>")
				.append("Course: ").append(className).append("<br/>Seat Number: "+seatNumber).append(("<br/>Time: "+startTime.toLocaleString()))
				.append("<br/><br/> Stony Brook Testing Scheduler Center.");
		return sb.toString();
	}
	
}
