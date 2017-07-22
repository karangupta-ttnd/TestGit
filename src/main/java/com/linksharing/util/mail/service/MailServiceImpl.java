package com.linksharing.util.mail.service;

import com.linksharing.dto.EMailerDTO;
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

	public void sendEmail(Object object) {

		EMailerDTO eMailerDTO=(EMailerDTO)object;

		MimeMessagePreparator preparator = getMessagePreparator(eMailerDTO);

		try {
			mailSender.send(preparator);
			System.out.println("Message Send...");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final EMailerDTO eMailerDTO ) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(eMailerDTO.getFrom());
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(eMailerDTO.getTo()));
				mimeMessage.setText(eMailerDTO.getBody() );
				mimeMessage.setSubject(eMailerDTO.getSubject());
			}
		};
		return preparator;
	}

}
