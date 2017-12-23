package tsc.web.utils;

import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EmailUtil {

	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private Properties props;
	private Session session;
	private static EmailUtil eu;

	private MimeMessage mimeMsg; 
	private Multipart mp;
	
	public static EmailUtil getInstance() {
		if (eu == null) {
			eu = new EmailUtil();
		}
		return eu;
	}

	private EmailUtil() {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		props = System.getProperties();
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", "995");
		props.setProperty("mail.pop3.socketFactory.port", "995");

		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(props, null);
		
	}

	
	
	 public void send(final String from,final String pwd,String to,String title,String content){
		 

		 try {
			createMimeMessage();
			 mimeMsg.setSubject(title);
				BodyPart bp = new MimeBodyPart();
				bp.setContent("" + content, "text/html;charset=GB2312");
				mp.addBodyPart(bp);
				mimeMsg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				mimeMsg.setFrom(new InternetAddress(from)); 
				mimeMsg.setContent(mp);
				Transport transport = session.getTransport("smtp");
				transport.connect((String) props.get("mail.smtp.host"), from,
						pwd);
				transport.sendMessage(mimeMsg,
						mimeMsg.getRecipients(Message.RecipientType.TO));
				LogUtils.outputINFO("EmailUtil", "send", "receiver : " + to +" content - "+ title + " ： "+content);
				transport.close();
		} catch (Exception e) {
			LogUtils.outputError("EmailUtil", "send", e.getMessage());
		}
			
		 
	 }
	 
		public boolean createMimeMessage() {
			try {
				System.out.println("prepared email session！");
			} catch (Exception e) {
				System.err.println("error in prepared email session！" + e);
				return false;
			}

		
			try {
				mimeMsg = new MimeMessage(session); 
				mp = new MimeMultipart();

				return true;
			} catch (Exception e) {
				System.err.println("Create MIME faile！" + e);
				return false;
			}
		}
}
