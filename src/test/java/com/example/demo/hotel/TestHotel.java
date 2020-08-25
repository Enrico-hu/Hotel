package com.example.demo.hotel;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestHotel {

	@Test
	public void testCreaHotel() {
		Hotel hotelTest = new Hotel();

		hotelTest.creaHotel(hotelTest);
		
		assertEquals(5, hotelTest.getStanzeHotel().length);
	
	}
	
	@Test
	public void testAggiornaCameraTrue() {
		Room roomTest = new Room();
		Reservation prenotazioneTest = new Reservation();
		Hotel hotelTest = new Hotel();
		boolean stato = true;
		
		hotelTest.setStanzeHotel(new Room[5]);
		for(int i = 0; i< 5; i++) {		
			hotelTest.getStanzeHotel()[i] = new Room();
		}
		
		hotelTest = hotelTest.aggiornaCamera(hotelTest, prenotazioneTest, stato);
		assertEquals(true, hotelTest.isStatoPrenotazione());
		
		prenotazioneTest.setNumeroStanzaPrenotata(0);
		roomTest.setLibera(false);
		hotelTest.getStanzeHotel()[0] = roomTest;
		stato = false;
		
		hotelTest = hotelTest.aggiornaCamera(hotelTest, prenotazioneTest, stato);
		assertEquals(false, hotelTest.isStatoPrenotazione());
		
		prenotazioneTest.setNumeroStanzaPrenotata(1);
		roomTest.setLibera(true);
		hotelTest.getStanzeHotel()[1] = roomTest;
		
		hotelTest = hotelTest.aggiornaCamera(hotelTest, prenotazioneTest, stato);
		assertEquals(true, hotelTest.isStatoPrenotazione());
		assertEquals(false, hotelTest.getStanzeHotel()[roomTest.getNumeroStanza()].isLibera());
	}

	@Test
	public void testAggiornaCameraStanzeLibereFalse() {
		Room roomTest = new Room();
		Reservation prenotazioneTest = new Reservation();
		Hotel hotelTest = new Hotel();
		boolean stato = false;
		
		hotelTest.setStanzeHotel(new Room[5]);
		for(int i = 0; i< 5; i++) {		
			hotelTest.getStanzeHotel()[i] = new Room();
			hotelTest.getStanzeHotel()[i].setLibera(true);
		}
		
		prenotazioneTest.setNumeroStanzaPrenotata(0);
		roomTest.setLibera(false);
		hotelTest.getStanzeHotel()[0] = roomTest;
		
		hotelTest = hotelTest.aggiornaCamera(hotelTest, prenotazioneTest, stato);
		assertEquals(false, hotelTest.isStatoPrenotazione());
	}
}
