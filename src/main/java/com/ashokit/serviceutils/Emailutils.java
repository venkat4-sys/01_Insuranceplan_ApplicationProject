package com.ashokit.serviceutils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Emailutils {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String subject,String body,String to,File f) {
		
		try {
			MimeMessage mimsg = mailsender.createMimeMessage();
			
			MimeMessageHelper msgHelper = new MimeMessageHelper(mimsg,true);
			
			msgHelper.setSubject(subject);
			msgHelper.setText(body,true);
			msgHelper.setTo(to);
			msgHelper.addAttachment("Plans-Info", f);

			mailsender.send(mimsg);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	

}
