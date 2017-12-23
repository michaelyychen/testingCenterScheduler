package tsc.web.bean.request;

import tsc.web.bean.FeedBackBean;
import tsc.web.utils.FeedBackUtils;

public class HttpResponseBean {
	
	public static final int SERVICE_SUCCESS = 1;

	
	private int result;
	
	private FeedBackBean feedback;
	
	public HttpResponseBean() {
		
			result = SERVICE_SUCCESS;
			feedback = new FeedBackBean();
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
			this.result = result;
			feedback = new FeedBackBean();
			feedback.setCode(result);
			feedback.setMessage(FeedBackUtils.feedbackTable.get(getResult()));
	
	}

	public FeedBackBean getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBackBean feedback) {
		this.feedback = feedback;
	}
	
	
	public boolean isSuccess(){
		
		return result == SERVICE_SUCCESS;
	}
	
}
