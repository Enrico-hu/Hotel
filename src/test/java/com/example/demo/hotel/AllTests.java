package com.example.demo.hotel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestReservation.class, TestRoom.class, TestHotel.class, TestMain.class})
public class AllTests {

}
