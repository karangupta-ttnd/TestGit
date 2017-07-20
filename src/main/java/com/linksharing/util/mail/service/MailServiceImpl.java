package com.linksharing.util.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(String email) {

		MimeMessagePreparator preparator = getMessagePreparator(email);

		try {
			mailSender.send(preparator);
			System.out.println("Message Send...Hurrey");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(String email) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("karangupta.199317@gmail.com");
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress("karan.gupta@tothenew.com"));
				mimeMessage.setText("test mail" );
				mimeMessage.setSubject("Your order on Demoapp");
			}
		};
		return preparator;
	}

}
