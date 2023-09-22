package com.springboard.hackathon.wraparound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboard.hackathon.wraparound.model.EmailRequest;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private JavaMailSender javaMailSender;

	
	@RequestMapping(method = RequestMethod.POST, value = "/send-email", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
		try {
			System.out.println("Started notification service");

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailRequest.getRecipient());
			message.setSubject(emailRequest.getSubject());
			message.setText(emailRequest.getMessage());

			// Set the sender's email address
			message.setFrom("shailendramishra.ind@gmail.com");

			javaMailSender.send(message);

			
	        return ResponseEntity.ok("Email sent successfully");
		} catch (Exception e) {
			// Handle email sending failure
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending failed");
		}
	}

}
