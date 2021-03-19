package com.hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public int findCheapestHotel(String date) throws ParseException {
        HotelInfo cheapestHotel;
        int noOfWeekDays = 0;
        int noOfWeekEnds = 0;
        String[] arr = date.split(",");
        int noOfDays = arr.length;
        for(int i=0; i<arr.length; i++) {
            String input_date1 = arr[i];
            SimpleDateFormat simpleDateFormat_Date1 = new SimpleDateFormat("dd/MM/yyyy");
            Date dt1 = simpleDateFormat_Date1.parse(input_date1);
            DateFormat dateFormat_Date1 = new SimpleDateFormat("EEEE");
            String day = dateFormat_Date1.format(dt1);
            if(day.equals("Saturday") || day.equals("Sunday")){
                noOfWeekEnds++;
            }
            else{
                noOfWeekDays++;
            }
        }
        int lakewoodRate = noOfWeekDays*hotel.get(0).weekDayRate + noOfWeekEnds*hotel.get(0).weekEndRate;
        int bridgewoodRate = noOfWeekDays*hotel.get(1).weekDayRate + noOfWeekEnds*hotel.get(1).weekEndRate;
        int ridgewoodRate = noOfWeekDays*hotel.get(2).weekDayRate + noOfWeekEnds*hotel.get(2).weekEndRate;
        List<Integer> hotelRates = new ArrayList<>();
        hotelRates.add(lakewoodRate);
        hotelRates.add(bridgewoodRate);
        hotelRates.add(ridgewoodRate);
        int cheapestRates = hotelRates.stream().min(Integer::compare).get();
        if(cheapestRates == lakewoodRate && cheapestRates == bridgewoodRate){
            System.out.println("Both "+hotel.get(0).hotelName+" and "+hotel.get(1).hotelName+" has rate "+cheapestRates);
        }
        else if(cheapestRates == lakewoodRate){
            cheapestHotel = hotel.get(0);
            System.out.println("For "+noOfDays+" days Hotel "+cheapestHotel.hotelName+" has cheapest rates "+cheapestRates);
        }
        else if(cheapestRates == bridgewoodRate){
            cheapestHotel = hotel.get(1);
            System.out.println("For "+noOfDays+" days Hotel "+cheapestHotel.hotelName+" has cheapest rates "+cheapestRates);
        }
        else{
            cheapestHotel = hotel.get(2);
            System.out.println("For "+noOfDays+" days Hotel "+cheapestHotel.hotelName+" has cheapest rates "+cheapestRates);
        }
        return cheapestRates;
    }
}
