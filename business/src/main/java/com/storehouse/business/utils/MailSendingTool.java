package com.storehouse.business.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailSendingTool {
	@Autowired
	private MailSender mailSender;

	public void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("kucheryavenko.dmtr@gmail.com");
		msg.setSubject("Some subject");
		msg.setText("text");
		mailSender.send(msg);
		System.out.println("sended");
		System.out.println(msg.getText());
	}
}
