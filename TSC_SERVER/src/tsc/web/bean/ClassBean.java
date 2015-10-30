package tsc.web.bean;

public class ClassBean {

	private int _id;
	private String classId;
	private String subject;
	private int catalogNumber;
	private String section;
	private String instructorNetID;
	private int term = 1;
	private String className;
	
	public ClassBean() {
		
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(int catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getInstructorNetID() {
		return instructorNetID;
	}

	public void setInstructorNetID(String instructorNetID) {
		this.instructorNetID = instructorNetID;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassBean [_id=" + _id + ", classId=" + classId + ", subject="
				+ subject + ", catalogNumber=" + catalogNumber + ", section="
				+ section + ", instructorNetID=" + instructorNetID + ", term="
				+ term + ", className=" + className + "]";
	}
	
	
}
