package com.hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
    public ArrayList<HotelInfo> hotel = new ArrayList<>();
    Map<HotelInfo,Integer> hotelRates = new HashMap<>();

    public void welcome(){
        System.out.println("Welcome to Hotel Reservation System");
    }

    public void addHotel(HotelInfo newData){
        hotel.add(newData);
    }

    public void toPrint(){
        for (HotelInfo h: hotel) {
            System.out.println(h.hotelName+", Rating: "+h.rating+", RegularWeekdayRates: "+h.regular.get(0)+", " +
                    "RegularWeekendRates: "+h.regular.get(1)+", RewardWeekdayRates: "+h.reward.get(0)+", RewardWeekendRates: "+h.reward.get(1));
        }
    }

    public ArrayList<HotelInfo> getHotels() {
        System.out.println(hotel);
        return hotel;
    }

    public void totalRates (String date) throws ParseException {
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
        for (HotelInfo h: hotel) {
            int cheapestRate = noOfWeekDays*h.regular.get(0) + noOfWeekEnds*h.regular.get(1);
            hotelRates.put(h,cheapestRate);
        }
    }

    public Map<HotelInfo, Integer> findCheapestHotel(String date) throws ParseException {
        Map<HotelInfo,Integer> cheapestHotel = new HashMap<>();
        totalRates(date);
        Integer cheapestRates = Integer.MAX_VALUE;
        for (HotelInfo h: hotel) {
            Integer value = hotelRates.get(h);
            int compare = value.compareTo(cheapestRates);
            if(compare < 0) {
                cheapestHotel.clear();
                cheapestRates = value;
                cheapestHotel.put(h,cheapestRates);
            }
            else if(compare == 0){
                cheapestHotel.put(h,cheapestRates);
            }
        }
        for (Map.Entry<HotelInfo,Integer> p: cheapestHotel.entrySet()) {
            System.out.println("Hotel "+p.getKey().hotelName+" has cheapest rate "+p.getValue());
        }
        return cheapestHotel;
    }

    public Map<HotelInfo, Integer> findCheapestHotelByRating(String date) throws ParseException {
        totalRates(date);
        Map<HotelInfo,Integer> cheapHotelByRating = new HashMap<>();
        Integer cheapestRates = Integer.MAX_VALUE;
        Integer highRating = Integer.MIN_VALUE;
        for (HotelInfo h: hotel) {
            Integer value = hotelRates.get(h);
            Integer rating = h.rating;
            int valueCompare = value.compareTo(cheapestRates);
            int ratingCompare = rating.compareTo(highRating);
            if (valueCompare < 0) {
                cheapHotelByRating.clear();
                cheapestRates = value;
                cheapHotelByRating.put(h, cheapestRates);
            } else if (valueCompare == 0 && ratingCompare > 0) {
                cheapHotelByRating.clear();
                highRating = rating;
                cheapHotelByRating.put(h, cheapestRates);
            } else if (valueCompare == 0 && ratingCompare == 0) {
                cheapHotelByRating.put(h, cheapestRates);
            }
        }
        for (Map.Entry<HotelInfo,Integer> p: cheapHotelByRating.entrySet()) {
            System.out.println("Hotel "+p.getKey().hotelName+" has cheapest rate "+p.getValue()+" with Rating "+highRating);
        }
        return cheapHotelByRating;
    }

    public Map<HotelInfo, Integer> findBestRatedHotel(String date) throws ParseException {
        Map<HotelInfo,Integer> bestRatedHotel = new HashMap<>();
        totalRates(date);
        Integer highRating = Integer.MIN_VALUE;
        for (HotelInfo h: hotel) {
            Integer rating = h.rating;
            int compare = rating.compareTo(highRating);
            if(compare > 0) {
                bestRatedHotel.clear();
                highRating = rating;
                bestRatedHotel.put(h,highRating);
            }
            else if(compare == 0){
                bestRatedHotel.put(h,highRating);
            }
        }
        for (Map.Entry<HotelInfo,Integer> p: bestRatedHotel.entrySet()) {
            System.out.println("Hotel "+p.getKey().hotelName+" has Best Ratings: "+p.getValue());
        }
        return bestRatedHotel;
    }
}

