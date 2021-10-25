package com.example.email.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.Dto.EmailDto;
import com.example.email.Service.EmailService;
import com.example.email.model.EmailModel;

@RestController
public class EmailController {
	private EmailService emailService;
	
	@PostMapping("/Send-Email")
	public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto emailDto){
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		
		return new ResponseEntity<>(emailModel, HttpStatus.OK);
	}
}
