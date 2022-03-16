package com.dutyroster;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

//    public ScheduledTask(){
//        Timer time = new Timer();
//    }
    public void run() {
        Sms sm = new Sms();
        sm.sendMessage();
        System.out.println("message sent!!!");
    }

}
