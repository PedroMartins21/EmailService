package com.example.email.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.email.Repository.EmailRepository;
import com.example.email.model.EmailModel;
import com.example.email.model.StatusEmail;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendDate(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getFrom());
			message.setTo(emailModel.getTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			
			emailSender.send(message);
			emailModel.setStatusEmail(StatusEmail.send);
			
			
			
		}catch (Exception ex) {
			emailModel.setStatusEmail(StatusEmail.error);
		}finally {
			return emailRepository.save(emailModel);
		}
		
	}
	
	public EmailModel GetEmail() {
		return (EmailModel) emailRepository.findAll();
	}
	
	public EmailModel GetFrom(String from) {
		return emailRepository.findByFrom(from);
	}
	
}
