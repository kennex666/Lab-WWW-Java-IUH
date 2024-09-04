package com.obxstd;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtils {
	private static String username = "1boxfordevelopers@gmail.com";
	private static String password = "";
	private static String host = "smtp.freesmtpservers.com";
	private static int port = 25;
	
	public static boolean sendMail(String to, String title, String body, String filename) throws Exception {
		Properties props = System.getProperties();

        props.put("mail.smtp.host", host); //SMTP Host
        props.put("mail.smtp.port", port);
		
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(username));
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		message.setSubject(title);
		
		
		BodyPart bp = new MimeBodyPart();
		bp.setText(body);

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bp);
		//
		bp = new MimeBodyPart();
		DataSource source = new FileDataSource(filename);
		bp.setDataHandler(new DataHandler(source));
		bp.setFileName(filename);
		
		multipart.addBodyPart(bp);
		
		message.setContent(multipart);
		
		Transport.send(message);
		return true;
	}
	
}
