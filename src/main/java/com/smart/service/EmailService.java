package com.smart.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to) {
		
		
		 // replace with your email password

		//rest of the code
		boolean f=false;
		String from = "nikhilaryankohli@gmail.com";
		String password = "unrr uubd zahk gkqe";
		
		//variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Step 1: to get the session object...
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
    });

		
		
		
		
		session.setDebug(true);
		
		//step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding the subject to message
			m.setSubject(subject);
			
			//adding text to message
//			m.setText(message);
			m.setContent(message,"text/html");
			
			//send
			
			//step 3 : send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent Success........");
			f=true;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	
	}
	
	
}
