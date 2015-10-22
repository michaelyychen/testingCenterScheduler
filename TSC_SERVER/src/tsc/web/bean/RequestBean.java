package tsc.web.bean;

public class RequestBean {

	private int userId;
	private ExamBean exam;
	private int status;
	public RequestBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ExamBean getExam() {
		return exam;
	}
	public void setExam(ExamBean exam) {
		this.exam = exam;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
