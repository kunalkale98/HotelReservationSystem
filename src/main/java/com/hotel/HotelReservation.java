package com.hotel;

import java.util.ArrayList;

public class HotelReservation {
    public static ArrayList<HotelInfo> hotel = new ArrayList<>();

    public void welcome(){
        System.out.println("Welcome to Hotel Reservation System");
    }

    public void addHotel(HotelInfo newData){
        hotel.add(newData);
    }

    public static ArrayList<HotelInfo> getHotels() {
        System.out.println(hotel);
        return hotel;
    }
}
