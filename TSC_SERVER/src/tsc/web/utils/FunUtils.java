package tsc.web.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.util.TypeUtils;


public class FunUtils {

	private static Logger log_e = Logger.getLogger("error");
	private static Logger log_i = Logger.getLogger("info");


	
	public static void outputError(String className, String methodName,
			Exception e) {

		String info = "ERROR:   ->  ClassName : " + className + " method:"
				+ methodName + " error：" + e.getMessage();
		log_e.error(info);
	}

	public static void outputInfo(String className, String methodName,
			String text) {

		String info = "INFOM:   -> ClassName : " + className + " method:"
				+ methodName + " info ：" + text;
		log_i.info(info);
	}

	
	public static void main(String[] args) {
		
	
		outputError("TEST", "TEST1", new Exception("output error"));
		outputInfo("TEST", "TEST2", "out put info");
	
	}

}
