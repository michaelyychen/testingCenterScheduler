package tsc.web.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import tsc.web.framework.ControllerServlet;

public class LogUtils {

	
	private static String TEST_CASE = "02";
	private static File error_log;
	private static File info_log;
	private static File db_log;
	
	
	
	public static final String TAG_DB = "[DB]";
	
	public static final String TAG_ERROR = "[ERROR]";
	
	public static final String TAG_TEST = "[TEST]";
	
	
	private static final String SPACE = " ";
	
	private static SimpleDateFormat df = new SimpleDateFormat(
			"yyyy/MM/dd kk:mm:ss");
	
	private static boolean init(){
		
		if(ControllerServlet.dir_log==null){
			return false;
		}
		String dir = "logs";
		if(TEST_CASE!=null){
			dir +=TEST_CASE;
		}
		
		if(error_log==null){
		
				error_log = new File(ControllerServlet.dir_log+"/"+dir+"/error.txt");
		
			
		}
		if(db_log==null){
		
				db_log = new File(ControllerServlet.dir_log+"/"+dir+"/db.txt");
			
		}
		if(info_log==null){
			
				info_log = new File(ControllerServlet.dir_log+"/"+dir+"/info.txt");
			
		}
		
		
		
		return true;
	}
	
	public static void outputDB(String className,String method,String info){
		
		if(init()){
				
			String text = getHead(TAG_DB, className, method) +info;
			log(0, text);
		
		}
		
	}
	
	public static void outputINFO(String className,String method,String info){
		
		if(init()){
				
			String text = getHead(TAG_TEST, className, method) +info;
			log(1, text);
			
		}
		
	}
	
	public static void outputError(String className,String method,String info){
		
		if(init()){
				
			String text = getHead(TAG_ERROR, className, method) +info;
			log(2, text);
			
		}
		
	}
	
	private static String getHead(String tag,String className,String method){
		
		StringBuffer sb = new StringBuffer(tag);
		sb.append(SPACE).append(df.format(new Date(System.currentTimeMillis())) + SPACE ).append(" Class : ").append(className).append(" Method : "+method +" - ");
		return sb.toString();
		
	}
	
	
	
	private static void log(int type,String text){
		
		File target;
		switch (type) {
		case 0:
			target = db_log;
			break;
		case 1:
			target = info_log;
			break;
		case 2:
			target = error_log;
			break;
		default:
			target = info_log;
			break;
		}
		
		try {
			System.out.println(text);
			FileUtils.writeStringToFile(target, text+"\n",true);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
