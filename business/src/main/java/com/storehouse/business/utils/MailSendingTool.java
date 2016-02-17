package com.storehouse.business.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.storehouse.business.services.TokenCreatingService;

@Component
public class MailSendingTool {
	@Autowired
	private MailSender mailSender;

	public void sendRegistrationEmail(String email, String link) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Welcome to Storehouse");
		msg.setText("To finish registration process, please, follow the link: \n \n"
				+ "http://localhost:8080/web/email_confirmation?val=" + link);
		mailSender.send(msg);
	}
}
