package tsc.web.bean;

import java.sql.Timestamp;

public class ExamBean {
	
	private int _id;
	private String identifier;
	private int courseId;
	private String courseName;
	private int duration;
	private Timestamp  beginDate;
	private Timestamp  beginTime;
	private Timestamp endDate;
	private Timestamp endTime;
	private int term; 
	private int examType;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getidentifier() {
		return identifier;
	}
	public void setidentifier(String examIdentifier) {
		this.identifier = examIdentifier;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Timestamp getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getExamType() {
		return examType;
	}
	public void setExamType(int examType) {
		this.examType = examType;
	}
	
	
}
