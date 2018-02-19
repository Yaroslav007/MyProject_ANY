package com.alwaysnearyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:email.properties")
public class MailServiceImpl{


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public void send(String email, int code) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom(env.getProperty("email.username"));
            helper.setText("Hello, your code: " + code + " !" + " If you did not register on our site, ignore this message, please!!!", true);
            helper.setTo(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }


}
