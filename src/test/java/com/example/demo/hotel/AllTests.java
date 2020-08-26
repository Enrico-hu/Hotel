package com.example.demo.hotel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestHotel.class, TestHotelRest.class, TestMain.class, TestReservation.class, TestReservationRest.class,
		TestRoom.class, TestRoomRest.class })
public class AllTests {

}
