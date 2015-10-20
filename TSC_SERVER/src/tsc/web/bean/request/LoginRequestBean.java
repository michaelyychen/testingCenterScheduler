package tsc.web.bean.request;

import javax.servlet.http.HttpServletRequest;

public class LoginRequestBean extends HttpRequestBean{

	private final String PARA_EMAIL = "username";
	//private final String PARA_USER_ID = "userid";
	private final String PARA_PWD = "password";
	
	private String email;
	private String userId;
	private String password;
	
	
	public LoginRequestBean(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validData() {
		
		if(email==null||email.trim().length()==0||password==null||password.trim().length()==0){
			return false;
		}
		return true;
	}

	@Override
	public void parseData() {
		
		if(mRequest!=null){
			email = mRequest.getParameter(PARA_EMAIL);
			userId = mRequest.getParameter(PARA_EMAIL);
			password = mRequest.getParameter(PARA_PWD);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	


}
