package tsc.web.bean;

public class CourseBean {

	private int _id;
	private int section;
	private int classid;
	private String courseIdentifier;
	private int termId;
	

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getCourseIdentifier() {
		return courseIdentifier;
	}

	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}

	public int getTermId() {
		return termId;
	}

	public void setTermId(int termId) {
		this.termId = termId;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
	
	

}
