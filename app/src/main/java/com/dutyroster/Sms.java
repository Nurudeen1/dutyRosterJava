package com.dutyroster;
import com.dutyroster.models.Member;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;


import com.dutyroster.DbConnection;
import org.apache.log4j.Logger;

public class Sms {

            Logger logger = Logger.getLogger(Sms.class.getName());
            public void sendMessage(){
                DynamoDbConnection connection = new DynamoDbConnection();



                Member mem = connection.getMemberById(DutyCalculator.calc(connection.getMemberSize()));
                String name = mem.getName();
                String phone = mem.getPhone();
                System.out.println(phone);

                Twilio.init(TwilioCred.getAccountSid(),TwilioCred.getAuthToken());
               try {
                   Message message = Message.creator(
                           new com.twilio.type.PhoneNumber(phone),
                           "MGf2e584af9ba5d507cfd55276c38a96b4",
                           String.format("\r\n\r\n Hello %s \n\n This is just a kind reminder that tomorrow is your clean-up day.\n Thank you for helping keep the house tidy.\n\n For more information, please visit https://fierce-reaches-38495.herokuapp.com.\n\n Have a great evening!",name.split(" ")))
                           .create();
                   System.out.println("Successfully sent to "+ mem.getName());
               }catch (Exception e){
                   System.out.println("Message sent failed");
                   e.printStackTrace();
               }

            }

}
