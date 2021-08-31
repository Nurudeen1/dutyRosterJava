package com.dutyroster;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        ScheduledTask taskToRun = new ScheduledTask();
        Timer taskTimer = new Timer();
        taskTimer.schedule(taskToRun, 2000, 60000);
    }
}
