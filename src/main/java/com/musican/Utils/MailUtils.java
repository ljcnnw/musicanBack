package com.musican.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtils  {

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Value("${mail.fromMail.addr}")
//    private String from;
//
//    public void sendSimpleMail(String to, String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(content);
//        try {
//            javaMailSender.send(message);
//            System.out.println("发送成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("发送失败");
//        }
//
//    }
}
