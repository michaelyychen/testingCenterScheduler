package tsc.web.bean;

public class RequestBean {

	private ExamBean exam;
	private int status;
	public RequestBean() {
		// TODO Auto-generated constructor stub
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
