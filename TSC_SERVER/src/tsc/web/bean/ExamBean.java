package tsc.web.bean;

import java.sql.Timestamp;

public class ExamBean {
	private int _id;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	private String identifier;
	private int courseId;
	private int duration;
	private Timestamp  beginTime;
	private Timestamp endTime;
	private int examType;
	private int examNumber;
	
	public int getExamNumber() {
		return examNumber;
	}
	public void setExamNumber(int examNumber) {
		this.examNumber = examNumber;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getExamType() {
		return examType;
	}
	public void setExamType(int examType) {
		this.examType = examType;
	}
	
	
	
}
