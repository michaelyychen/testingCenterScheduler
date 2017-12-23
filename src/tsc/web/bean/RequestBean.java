package tsc.web.bean;

public class RequestBean {

	private int _id;
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	private int userId;
	private ExamBean exam;
	private int status;
	private ClassBean classBean;
	
	public RequestBean() {
		// TODO Auto-generated constructor stub
		exam = new ExamBean();
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

	public ClassBean getClassBean() {
		return classBean;
	}

	public void setClassBean(ClassBean classBean) {
		this.classBean = classBean;
	}

	
	
	
	
}
