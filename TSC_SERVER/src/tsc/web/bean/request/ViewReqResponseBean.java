package tsc.web.bean.request;

import java.util.List;

import tsc.web.bean.RequestBean;

public class ViewReqResponseBean extends HttpResponseBean {

	private List<RequestBean> requests;
	public List<RequestBean> getRequests() {
		return requests;
	}
	public void setRequests(List<RequestBean> requests) {
		this.requests = requests;
	}
	public ViewReqResponseBean() {
		// TODO Auto-generated constructor stub
		
	}
}
