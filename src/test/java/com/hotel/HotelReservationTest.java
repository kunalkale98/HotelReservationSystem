package com.hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationTest {
    HotelReservation hotelReservation;
    public HotelInfo lakewood = new HotelInfo("Lakewood", 3,110,90,80,80);
    HotelInfo bridgewood = new HotelInfo("Bridgewood", 4,150,50,110,50);
    HotelInfo ridgewood = new HotelInfo("Ridgewood", 5,220,150,100,40);

    @Before
    public void setup() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
    }

    @Test
    public void givenHotelName_ToCheckInfoAdded_ShouldReturnTrue() {
        hotelReservation.welcome();
        Assert.assertTrue(hotelReservation.hotel.contains(lakewood));
        Assert.assertTrue(hotelReservation.hotel.contains(bridgewood));
        Assert.assertTrue(hotelReservation.hotel.contains(ridgewood));
        hotelReservation.toPrint();
    }

    @Test
    public void givenDateRange_ToFindTheCheapestHotel_ShouldReturnTrue() throws ParseException {
        String date = "11/09/2020,12/09/2020";
        Map<HotelInfo,Integer> map = hotelReservation.findCheapestHotel(date);
        Boolean hotelName = false;
        for (Map.Entry<HotelInfo,Integer> h: map.entrySet()) {
            if(h.getKey().hotelName.equals("Lakewood") || h.getKey().hotelName.equals("Bridgewood")){
                hotelName = true;
            }
            int rate = h.getValue();
            Assert.assertTrue(hotelName);
            Assert.assertEquals(200,rate);
        }
    }

    @Test
    public void givenDateRange_ToFindTheCheapHotelWithBestRating_ShouldReturnTrue() throws ParseException {
        String date = "11/09/2020,12/09/2020";
        Map<HotelInfo,Integer> map = hotelReservation.findCheapestHotelByRating(date);
        Boolean result = false;
        for (Map.Entry<HotelInfo,Integer> h: map.entrySet()) {
            if(h.getKey().hotelName.equals("Bridgewood") && h.getKey().rating == 4 && h.getValue() == 200){
                result = true;
            }
            Assert.assertTrue(result);
        }
    }

    @Test
    public void givenDateRange_ToFindTheBestRatedHotel_ShouldReturnTrue() throws ParseException {
        String date = "11/09/2020,12/09/2020";
        Map<HotelInfo,Integer> map = hotelReservation.findBestRatedHotel(date);
        Boolean result = false;
        for (Map.Entry<HotelInfo,Integer> h: map.entrySet()) {
            if(h.getKey().hotelName.equals("Ridgewood") && h.getKey().rating == 5){
                result = true;
            }
            Assert.assertTrue(result);
        }
    }

    @Test
    public void givenRating_ToCheckTheRatings_ShouldReturnTrue() {
        Assert.assertEquals(3,lakewood.rating);
        Assert.assertEquals(4,bridgewood.rating);
        Assert.assertEquals(5,ridgewood.rating);
    }

    @Test
    public void givenRates_ToCheckTheWeekendRates_ShouldReturnTrue() {
        int lakewoodWeekend = lakewood.regular.get(1);
        int bridgewoodWeekend = bridgewood.regular.get(1);
        int ridgewoodWeekend = ridgewood.regular.get(1);
        Assert.assertEquals(90,lakewoodWeekend);
        Assert.assertEquals(50,bridgewoodWeekend);
        Assert.assertEquals(150,ridgewoodWeekend);
    }
}
