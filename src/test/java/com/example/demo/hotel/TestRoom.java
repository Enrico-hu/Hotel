package com.example.demo.hotel;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestRoom {

	@Test
	public void testCreaStanza() {
		Room roomTest = new Room();

		roomTest.creaStanza(roomTest, 1, 1, 1);
		
		assertEquals(1, roomTest.getNumeroStanza());
		assertEquals(1, roomTest.getPiano());
		assertEquals(1, roomTest.getNumeroLetti());
		assertEquals(true, roomTest.isLibera());
	}
	
	@Test
	public void testPrenota() throws ParseException {
		Room roomTest = new Room();
		Hotel hotelTest = new Hotel();
		String nome = "enrico";
		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020");
		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("22/08/2020");
		boolean flagPagamento = true;
				
		hotelTest.setStanzeHotel(new Room[5]);
		for(int i = 0; i< 5; i++) {		
			hotelTest.getStanzeHotel()[i] = new Room();
			hotelTest.getStanzeHotel()[i].creaStanza(hotelTest.getStanzeHotel()[i], i, (int) (Math.random()*3)+1, (int) (Math.random()*3)+1);
		}
		
		roomTest.creaStanza(roomTest, 1, 1, 1);
		
		hotelTest.getStanzeHotel()[0].setLibera(true);
		hotelTest.getStanzeHotel()[1].setLibera(true);
		hotelTest.getStanzeHotel()[2].setLibera(true);
		hotelTest.getStanzeHotel()[3].setLibera(true);
		hotelTest.getStanzeHotel()[4].setLibera(true);
		
		Room.prenota(hotelTest, nome, dataArrivo, dataPartenza, flagPagamento);
		
		assertEquals(true, hotelTest.getStanzeHotel()[0].isLibera());
		assertEquals(true, hotelTest.getStanzeHotel()[1].isLibera());
//se faccio gli assert per le posizioni 2, 3 e 4 mi va in failure 
	}
}
