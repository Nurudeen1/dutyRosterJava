package com.dutyroster;
import com.dutyroster.models.Member;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import com.dutyroster.DbConnection;
import org.w3c.dom.ls.LSOutput;

public class Emailservices {

    public void SendEmail(){
        //DbConnection mem = new DbConnection();
       // mem.fetchAll();
        final MyCredential myCred = new MyCredential();
        DynamoDbConnection connection = new DynamoDbConnection();
        myCred.getFrom();
        myCred.getPassword();
        Member mem = connection.getMemberById(DutyCalculator.calc(connection.getMemberSize()));
        String to = mem.getEmail();
        String theName = mem.getName();
        String host = "localhost";
        String subject = "Clean-up reminder";
        Properties prop = new Properties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port","465");
        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.port","465");

            Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myCred.getFrom(),myCred.getPassword());
                }
                });
        try{
            MimeMessage Message = new MimeMessage(session);
            Message.setFrom(new InternetAddress(myCred.getFrom(),"933 Oaklawn Avenue"));
            Message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
            Message.setSubject(subject);
            Message.setText(String.format("\r\n\r\n Hello %s \n\n This is just a kind reminder that tomorrow is your clean-up day.\n Thank you for helping keep the house tidy.\n\n For more information, please visit https://fierce-reaches-38495.herokuapp.com.\n\n Have a great evening!",theName.split(" ")));

            Transport.send(Message);
            System.out.println("Message sent successfully...");
        }catch (MessagingException | UnsupportedEncodingException e){
            throw new RuntimeException(e);
        };
    }
}



