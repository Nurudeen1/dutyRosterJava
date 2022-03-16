package com.dutyroster;

import com.dutyroster.models.Member;

import java.time.LocalDate;
import java.time.Period;

public class DutyCalculator {
    private DutyCalculator(){

    }

    public static int calc(int capacity){

        LocalDate startDate = LocalDate.of(2021,8,26);
        LocalDate today = LocalDate.now();
        LocalDate scrubDay = today.plusDays(6-today.getDayOfWeek().getValue());
        Period period = Period.between(startDate,scrubDay);
        return (period.getDays()/7)%capacity;
    }

}
