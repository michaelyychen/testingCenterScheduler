package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.utils.FunUtils;

public class ViewReqRequestBean extends HttpRequestBean<Integer> {

	public static final String PARA_USER_ROLE = "userRole";
	private int role;
	private int _id;
	
	public ViewReqRequestBean(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}


	

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public boolean validData() {
		// TODO Auto-generated method stub
		if(role < 0){
			return false;
		}
		if(_id < 0){
			return false;
		}
		return true;
	}

	@Override
	public void parseData() {
		// TODO Auto-generated method stub
		setRole(FunUtils.getUser(mRequest).getRole());
		set_id(FunUtils.getUser(mRequest).get_id());
	}

	public int get_id() {
		return _id;
	}




	public void set_id(int _id) {
		this._id = _id;
	}




	@Override
	public Integer getObject() {
		// TODO Auto-generated method stub
		return role;
	}
	
}
