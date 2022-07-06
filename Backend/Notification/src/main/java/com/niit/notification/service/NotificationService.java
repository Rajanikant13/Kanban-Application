package com.niit.notification.service;

import javax.mail.MessagingException;
import java.io.IOException;

public interface NotificationService {
    public boolean sendEmail();
//    public UserDetails add(UserDetails userDetails);
    public void sendMail(String email,String message) throws MessagingException, IOException;
//    public UserDetails getDetailsToMail();
//    public boolean sendMail(String email,String message);
}
