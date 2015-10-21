package tsc.web.utils;

import java.util.HashMap;

import tsc.web.bean.FeedBackBean;

public class FeedBackUtils {

	//Message
	public static final int FB_CODE_APPOINTMENT_OVERLAPPING = 1000;
	public static final String FB_TEXT_APPOINTMENT_OVERLAPPING = "FB_TEXT_APPOINTMENT_OVERLAPPING";
	
	//DB Results
	public static final int FB_CODE_APPOINTMENT_ADD_FAIL = 2000;
	public static final String FB_TEXT_APPOINTMENT_ADD_FAIL = "FB_TEXT_APPOINTMENT_ADD_FAIL";
	
	public static final int FB_CODE_APPOINTMENT_NO_PERMISSION = 2001;
	public static final String FB_TEXT_APPOINTMENT_NO_PERMISSION = "FB_TEXT_APPOINTMENT_NO_PERMISSION";
	
	public static final int FB_CODE_APPOINTMENT_UPDATE_STATUS_FAIL = 2002;
	public static final String FB_TEXT_APPOINTMENT_UPDATE_STATUS_FAIL = "FB_TEXT_APPOINTMENT_UPDATE_STATUS_FAIL";
	
	
	
	
	
	public static HashMap<Integer, String> feedbackTable;
	
	
	static{
		
		feedbackTable = new HashMap<Integer, String>();
		feedbackTable.put(FB_CODE_APPOINTMENT_OVERLAPPING, FB_TEXT_APPOINTMENT_OVERLAPPING);
		feedbackTable.put(FB_CODE_APPOINTMENT_ADD_FAIL, FB_TEXT_APPOINTMENT_ADD_FAIL);
		feedbackTable.put(FB_CODE_APPOINTMENT_NO_PERMISSION, FB_TEXT_APPOINTMENT_NO_PERMISSION);
		
		
	}
	
	
	
	
	
	
}
