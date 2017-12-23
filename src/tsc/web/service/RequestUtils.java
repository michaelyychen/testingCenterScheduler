package tsc.web.service;

import tsc.web.dao.RequestDao;

public class RequestUtils {
	
	private static final int REQ_STATUS_APPROVE = 4;
	private static final int REQ_STATUS_DENY = 5;
	private static final int REQ_STATUS_SUBMIT = 2;
	private static final int REQ_STATUS_CANCEL = 3;
	
	RequestDao requestdao;
	public RequestUtils(RequestDao requestDao) {
		// TODO Auto-generated constructor stub
		requestdao = requestDao;
	}
	
	public static boolean checkUpdateRequestStatusPermission(int role, int status){
		if(role == 3 && (status == REQ_STATUS_APPROVE || status == REQ_STATUS_DENY)) return true;
		if(role == 2 && (status == REQ_STATUS_SUBMIT ||status == REQ_STATUS_CANCEL)) return true;
		
		return false;
			
			
	}
}
