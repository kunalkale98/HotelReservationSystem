package com.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelInfo {
    String hotelName;
    int rating;
    List<Integer> regular = new ArrayList<>();
    List<Integer> reward = new ArrayList<>();

    public HotelInfo(String hotelName,int rating,int regWeekDayRate,int regWeekEndRate, int rewWeekDayRate, int rewWeekEndRate){
        this.hotelName = hotelName;
        this.rating = rating;
        this.regular.add(regWeekDayRate);
        this.regular.add(regWeekEndRate);
        this.reward.add(rewWeekDayRate);
        this.reward.add(rewWeekEndRate);
    }
}
