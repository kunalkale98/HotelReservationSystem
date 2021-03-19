package com.hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

public class HotelReservationTest {
    HotelReservation hotelReservation;
    HotelInfo lakewood = new HotelInfo("Lakewood", 110,90);
    HotelInfo bridgewood = new HotelInfo("Bridgewood", 150,50);
    HotelInfo ridgewood = new HotelInfo("Ridgewood", 220,150);

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
        Assert.assertTrue(hotelReservation.getHotels().contains(lakewood));
        Assert.assertTrue(hotelReservation.getHotels().contains(bridgewood));
        Assert.assertTrue(hotelReservation.getHotels().contains(ridgewood));
        hotelReservation.toPrint();
    }

    @Test
    public void givenDateRange_ToFindTheCheapestHotel_ShouldReturnCheapestRate() throws ParseException {
        String date = "11/09/2020,12/09/2020";
        int hotelRate = hotelReservation.findCheapestHotel(date);
        Assert.assertEquals(200,hotelRate);
    }

    @Test
    public void givenRates_ToCheckTheWeekendRates_ShouldReturnTrue() {
        Assert.assertEquals(90,lakewood.weekEndRate);
        Assert.assertEquals(50,bridgewood.weekEndRate);
        Assert.assertEquals(150,ridgewood.weekEndRate);
    }
}
