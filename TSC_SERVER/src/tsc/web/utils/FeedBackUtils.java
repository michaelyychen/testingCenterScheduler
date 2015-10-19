package tsc.web.utils;

import java.util.HashMap;

public class FeedBackUtils {

	//Message
	public static final int FB_CODE_APPOINTMENT_OVERLAPPING = 1000;
	public static final String FB_TEXT_APPOINTMENT_OVERLAPPING = "FB_TEXT_APPOINTMENT_OVERLAPPING";
	
	//DB Results
	public static final int FB_CODE_APPOINTMENT_ADD_FAIL = 2000;
	public static final String FB_TEXT_APPOINTMENT_ADD_FAIL = "FB_TEXT_APPOINTMENT_ADD_FAIL";
	
	
	
	
	
	public static HashMap<Integer, String> feedbackTable;
	
	
	static{
		
		feedbackTable = new HashMap<Integer, String>();
		feedbackTable.put(FB_CODE_APPOINTMENT_OVERLAPPING, FB_TEXT_APPOINTMENT_OVERLAPPING);
		
		
	}
	
	
	
	
	
	
}
