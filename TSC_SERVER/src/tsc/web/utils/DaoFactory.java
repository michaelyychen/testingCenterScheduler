package tsc.web.utils;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();
	private Properties prop = new Properties();
	private DaoFactory(){
		try {
			prop.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static DaoFactory getInstance(){
		return instance;
	}
	                        
	public <T> T createDao(Class<T> daoType){
		
		String daoName = daoType.getSimpleName(); 
		String daoClassName = prop.getProperty(daoName);
		if(daoClassName==null){
			throw new RuntimeException("not found " + daoName + " dao");
		}
		try {
			return (T) Class.forName(daoClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
}
