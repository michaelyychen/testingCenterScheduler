package tsc.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import  tsc.web.utils.Constants;
import tsc.web.bean.AppointmentBean;
import tsc.web.bean.ErrorBean;
import tsc.web.bean.JsonBean;
import tsc.web.bean.SeatBean;
import tsc.web.bean.UserBean;
import tsc.web.dao.impl.AppointmentDataManager;
import tsc.web.dao.impl.TSCInfoDataManager;
import tsc.web.dao.impl.UserDataManager;
import tsc.web.framework.Control;
import tsc.web.framework.Controller;
import tsc.web.utils.EmailUtil;
import tsc.web.utils.FunUtils;
import tsc.web.utils.LogUtils;
import tsc.web.utils.MessageUtils;

@Control("/control/test")
public class TestController  implements Controller  {

	AppointmentDataManager appDataManager = new AppointmentDataManager();
	UserDataManager userDataManager = new UserDataManager();
	TSCInfoDataManager tscInfoDataManager = new TSCInfoDataManager();
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
	}



	
	
	
	public void testFindUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if(!FunUtils.isLogin(request)){
			FunUtils.goToLoginPage(response);
			return;
		}
		
		UserBean user = userDataManager.findUser("sunyu90@hotmail.com", "101131607","123456");
	
		LogUtils.outputINFO("TestController", "testFindUser", JSON.toJSONString(user));

		outHTML(response, user);
	}
	
	public void testGetAvaSeats(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		List<SeatBean> result = appDataManager.getAvaSeats(1, 1);
	
		LogUtils.outputINFO("TestController", "testGetAvaSeats", JSON.toJSONString(result));
		
		outHTML(response, result);

		
	}
	
	public void testCeateAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		int result = appDataManager.addAppointment(6, 1, "101131607", 4);
	
		LogUtils.outputINFO("TestController", "testCeateAppointment", String.valueOf((result > 0)));
		
		
		
		outHTML(response, result);

		
	}
	
	public void testSendEmail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		EmailUtil.getInstance().send("sbu.testing.scheduler.center@gmail.com", "Sy83448095","sunyu90@hotmail.com", "Make Appointment Test", "Test Message");
		
		outHTML(response, "test");
	
	}
	
	public void testDeleteAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		int result = appDataManager.deleteAppointment("101131608", 12,3);
	
		LogUtils.outputINFO("TestController", "testDeleteAppointment", String.valueOf((result > 0)));
		
		
		outHTML(response, result);

		
	}
	
	public void testUpdateAppointmentStatus(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		int result = appDataManager.updateAppoinmentStatus(2, 15);
	
		LogUtils.outputINFO("TestController", "testUpdateAppointmentStatus", String.valueOf((result > 0)));
		
		outHTML(response, result);

		
	}
	
	public void testViewAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		List<AppointmentBean> result = appDataManager.getAppointments("101131607", 1,2);
	
		LogUtils.outputINFO("TestController", "testViewAppointmentStatus",JSON.toJSONString(result));
		
		outHTML(response, result);

		
	}
	
	public void testUpdateTsc(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		
		int  result =	tscInfoDataManager.updateTSC(new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 
				100, 20, 40, 30, "9:00am - 5:30pm");
	
		LogUtils.outputINFO("TestController", "testUpdateTsc", String.valueOf((result > 0)));
		
		outHTML(response, result);

		
	}
	
	public void errorPage(HttpServletRequest request,HttpServletResponse response,String message) throws ServletException, IOException{
		
		request.setAttribute("error", new ErrorBean(message));
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}
	
	public static void outHTML(HttpServletResponse response, Object num) {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;
		int code = Constants.SUCCESS;
		String message = MessageUtils.MSG_SUCCESS;
		JsonBean json = new JsonBean(code, message, null);
		String result = null;
		try {
			out = response.getWriter();
			json.setData(num);
			result = JSON.toJSONString(json);
			out.print(result);
		} catch (Exception e) {
			json = new JsonBean(Constants.ERROR_RUNTIME_EXCEPTION,
					MessageUtils.MSG_ERROR_RUNTIME, null);
			String str = JSON.toJSONString(json);
			out.print(str);
		
		} finally {
			out.flush();
			out.close();
		}
	}










	@Override
	public void jsonDataResponse() {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void webPageResponse(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
