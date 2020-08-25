package com.example.demo.hotel;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestMain {

	@Test
	public void test() throws ParseException {
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		String nomePrenotazione = "Enrico";
		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2020");
		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("03/09/2020");
		boolean flagPagamento = true;
		
		Main.main(null);
		Reservation p = Room.prenota(hotel, nomePrenotazione, dataArrivo, dataPartenza, flagPagamento);
		
		assertEquals("Enrico", p.getNomePrenotazione());
		assertEquals(dataArrivo, p.getDataArrivo());
		assertEquals(dataPartenza, p.getDataPartenza());
		assertEquals(true, p.isFlagEffettuaPagamento());
	}

}
