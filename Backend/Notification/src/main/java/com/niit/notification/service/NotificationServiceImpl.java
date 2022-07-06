package com.niit.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

@Service
public class NotificationServiceImpl implements NotificationService {




//    private UserDetails detailsToMail;
//    public UserDetails add(UserDetails userDetails){
//        this.detailsToMail=userDetails;
//        return repo.save(userDetails);
//    }
//    public UserDetails getDetailsToMail(){
//        return this.detailsToMail;
//    }
//private UserDetailsRepo repo;






    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendMail(String email,String info) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //setting properties done
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kanban11board@gmail.com", "kanban@123");//sender mail and pwd
            }
        });//setting session done
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("kanban11board@gmail.com", false));//sender mail
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));//rx mail
        msg.setSubject("Hello Customer");
        msg.setContent(info, "text/html");//info
        Transport.send(msg);//sending message
    }



    @Override
    public boolean sendEmail() {

        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("dwarakasuran@gmail.com");
            message.setTo("mdwaraka99@gmail.com");
            message.setText("Sample Message....");
            mailSender.send(message);
            System.out.println(">>>Loading ");
//            repo.save(userDetails);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
