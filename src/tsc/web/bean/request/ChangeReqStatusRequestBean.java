package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

public class ChangeReqStatusRequestBean extends HttpRequestBean<Integer []> {

	public static final String PARA_REQUEST_ID = "requestId";
	public static final String PARA_REQUEST_STATUS = "requestStatus";
	private int _id;
	private int status;
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ChangeReqStatusRequestBean(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		if(status < 0 || _id < 0) return false;
		return true;
	}

	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		set_id(TypeUtils.castToInt(mRequest.getParameter(PARA_REQUEST_ID)));
		setStatus(TypeUtils.castToInt(mRequest.getParameter(PARA_REQUEST_STATUS)));
	}

	@Override
	public Integer[] getObject() {
		// TODO Auto-generated method stub
		return (new Integer[]{_id, status});
	}

}
