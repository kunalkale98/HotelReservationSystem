package com.hotel;

public class HotelInfo {
    String hotelName;
    int weekDayRate;
    int weekEndRate;

    public HotelInfo(String hotelName,int weekDayRate,int weekEndRate){
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }

    public int getWeekDayRate(){
        return weekDayRate;
    }

    public  int getWeekEndRate(){
        return weekEndRate;
    }
}
