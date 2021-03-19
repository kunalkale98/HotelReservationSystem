package com.hotel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class HotelReservation {
    public static ArrayList<HotelInfo> hotel = new ArrayList<>();

    public void welcome(){
        System.out.println("Welcome to Hotel Reservation System");
    }

    public void addHotel(HotelInfo newData){
        hotel.add(newData);
    }

    public void toPrint(){
        for (HotelInfo h: hotel) {
            System.out.println(h.hotelName+" "+h.weekDayRate+","+h.weekEndRate);
        }
    }

    public static ArrayList<HotelInfo> getHotels() {
        System.out.println(hotel);
        return hotel;
    }

    public HotelInfo findCheapestHotel(String date) {
        String[] arr = date.split(",");
        int noOfDays = arr.length;
        HotelInfo cheapestHotel = hotel.stream().min(Comparator.comparing(HotelInfo::getWeekDayRate))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("For "+noOfDays+" days Hotel "+cheapestHotel.hotelName+" has cheapest rates "+cheapestHotel.weekDayRate*noOfDays);
        return cheapestHotel;
    }
}
