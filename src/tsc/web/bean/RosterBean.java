package tsc.web.bean;

public class RosterBean {

	private String netId;
	private String classId;
	
	public RosterBean() {
	
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "RosterBean [netId=" + netId + ", classId=" + classId + "]";
	}
	
	
	
}
