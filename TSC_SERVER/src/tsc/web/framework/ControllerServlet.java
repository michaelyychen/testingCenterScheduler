package tsc.web.framework;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.apache.commons.io.FileUtils;





import tsc.web.bean.AppointmentReminderBean;
import tsc.web.service.AppointmentService;
import tsc.web.utils.DaoFactory;
import tsc.web.utils.EmailUtil;


public class ControllerServlet extends HttpServlet {


	private Map<String,Object> map = new HashMap();

	public static String website_root;
	public static String root = null;
	public static String file_root = null;
	public static String dir_log = null;
	public static Date lastTime;

	public static Date current;
	public static int alertCount = 0;
	Timer reminderTimer;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		try{
//			reminderTimer = new Timer("reminderTimer");
//			reminderTimer.schedule(new TimerTask() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					List<AppointmentReminderBean> reminders = new AppointmentService().getReminders();
//					if(reminders.size()>0){
//						for(AppointmentReminderBean reminder : reminders){
//							EmailUtil.getInstance().send("sbu.testing.scheduler.center@gmail.com", "Sy83448095",
//									reminder.getEmail(),"Exam Reminder" ,reminder.getEmailContent());
//							
//						}
//					}
//				}
//			}, 1000,1000*60*1000);
			website_root = this.getServletContext().getRealPath("/WEB-INF");
			file_root = this.getServletContext().getRealPath("/files");
			dir_log = this.getServletContext().getRealPath("/file/logs");
			String classpath = this.getServletContext().getRealPath("/WEB-INF/classes");
			
			scanClass(new File(classpath));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		
		
	}
	
	private void scanClass(File file) throws Exception {
		if(file.isFile()){
		
			if(file.getName().endsWith(".class")){
				String path = file.getPath();  //   c:\apa\tomcat\...\WEB-INF\classes\CartControl.class
				
				MyClassLoader classloader = new MyClassLoader(ControllerServlet.class.getClassLoader());
		
				Class clazz = classloader.load(path);
				
			
				Annotation annotation = clazz.getAnnotation(Control.class);
				if(annotation!=null){
				
					if(!Controller.class.isAssignableFrom(clazz)){
						throw new RuntimeException("error");
					}
					Control control = (Control) annotation;
					String uri = control.value();
					Object obj = clazz.newInstance();
				
					map.put(uri, obj);
				}
			}
		}else{
			File files[] = file.listFiles();
			for(File children : files){
				scanClass(children);
			}
		}
	}
	
	class MyClassLoader extends ClassLoader{
		
		public MyClassLoader(ClassLoader parent){
			super(parent);
		}
		

		public Class load(String path) throws Exception{
			
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			FileInputStream in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			while((len=in.read(buffer))>0){
				bout.write(buffer, 0, len);
			}
			

			byte b[] = bout.toByteArray();
			return super.defineClass(null, b, 0, b.length);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();     //   /day12/servlet/cart.do
		uri = uri.substring(request.getContextPath().length(),uri.length()-3);
		String url = request.getRequestURL().toString();
		
		

		Object obj = map.get(uri);
		if(obj==null){
			throw new RuntimeException("not found a：" + uri + "can match this control");
		}

		String methodName = request.getParameter("method");
	
		
		if(methodName==null){
			methodName = "exec";
		}

		
		Method method;
		try {
		
			method = obj.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Not found" + methodName);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try {
			method.invoke(obj, request,response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
