package com.springboard.hackathon.wraparound.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;
    
    @Value(value = "${spring.mail.fromUserEmail}")
    private String fromUserEmail;
    
    @Value(value = "${spring.mail.fromUserFullName}")
    private String fromUserFullName;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword("BHlpVkTeBitDMhJJ6UADOVsP5wh67xF8UxUZTLeEL4lg");

        return mailSender;
    }
}
