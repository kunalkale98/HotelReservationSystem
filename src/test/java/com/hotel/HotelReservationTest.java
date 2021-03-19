package com.hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    HotelReservation hotelReservation;
    HotelInfo lakewood = new HotelInfo("Lakewood", 110);
    HotelInfo bridgewood = new HotelInfo("Bridgewood", 160);
    HotelInfo ridgewood = new HotelInfo("Ridgewood", 220);

    @Before
    public void setup() {
        hotelReservation = new HotelReservation();
        hotelReservation.welcome();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
    }

    @Test
    public void givenHotelName_ToCheckInfoAdded_ShouldReturnTrue() {
        Assert.assertTrue(hotelReservation.getHotels().contains(lakewood));
        Assert.assertTrue(hotelReservation.getHotels().contains(bridgewood));
        Assert.assertTrue(hotelReservation.getHotels().contains(ridgewood));
        hotelReservation.toPrint();
    }

    @Test
    public void name() {
        String date = "10/09/2020,11/09/2020";
        HotelInfo cheapHotel = hotelReservation.findCheapestHotel(date);
        Assert.assertEquals(lakewood.hotelName,cheapHotel.hotelName);
    }
}
