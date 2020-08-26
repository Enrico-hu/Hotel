package com.example.demo.hotel;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.example.demo.om.AggiornaCameraRequest;
import com.example.demo.om.AggiornaCameraResponse;
import com.example.demo.om.CreaHotelResponse;
import com.example.demo.web.HotelREST;

public class TestHotelRest {

	@Test
	public void testCreaHotelRest() {

		CreaHotelResponse response = new CreaHotelResponse();
		HotelREST h = new HotelREST();
		
		response = h.creaHotelREST();
		
		assertEquals(0, response.getValueError());
		
	}

	@Test
	public void testAggiornaCameraRest() throws ParseException {

		AggiornaCameraRequest request = new AggiornaCameraRequest();
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		HotelREST h = new HotelREST();
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		request.setPrenotazione(new Reservation());
		request.getPrenotazione().setNumeroStanzaPrenotata(1);
		request.getPrenotazione().setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.getPrenotazione().setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.getPrenotazione().setFlagEffettuaPagamento(true);
		request.getPrenotazione().setNomePrenotazione("Enrico");
		request.setStatoPrenotazione(false);
		request.setHotel(hotel);
		
		response = h.aggiornaCameraREST(request);
		
		assertEquals(0, response.getValueError());
	}
	
	@Test
	public void testAggiornaCameraRestPrenotazioneTrue() throws ParseException {

		AggiornaCameraRequest request = new AggiornaCameraRequest();
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		HotelREST h = new HotelREST();
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		request.setPrenotazione(new Reservation());
		request.getPrenotazione().setNumeroStanzaPrenotata(1);
		request.getPrenotazione().setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.getPrenotazione().setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.getPrenotazione().setFlagEffettuaPagamento(true);
		request.getPrenotazione().setNomePrenotazione("Enrico");
		request.setStatoPrenotazione(true);
		request.setHotel(hotel);
		
		response = h.aggiornaCameraREST(request);
		
		assertEquals(1, response.getValueError());

	}
	
	@Test
	public void testAggiornaCameraRestNoLibera() throws ParseException {

		AggiornaCameraRequest request = new AggiornaCameraRequest();
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		HotelREST h = new HotelREST();
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		request.setPrenotazione(new Reservation());
		request.getPrenotazione().setNumeroStanzaPrenotata(1);
		request.getPrenotazione().setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.getPrenotazione().setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.getPrenotazione().setFlagEffettuaPagamento(true);
		request.getPrenotazione().setNomePrenotazione("Enrico");
		request.setStatoPrenotazione(false);
		
		hotel.getStanzeHotel()[1].setLibera(false);
		request.setHotel(hotel);
		
		response = h.aggiornaCameraREST(request);
		
		assertEquals(1, response.getValueError());

	}
	
	@Test
	public void testAggiornaCameraRest2() throws ParseException {

		AggiornaCameraRequest request = new AggiornaCameraRequest();
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		HotelREST h = new HotelREST();
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		request.setPrenotazione(new Reservation());
		request.getPrenotazione().setNumeroStanzaPrenotata(1);
		request.getPrenotazione().setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.getPrenotazione().setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.getPrenotazione().setFlagEffettuaPagamento(true);
		request.getPrenotazione().setNomePrenotazione("Enrico");
		request.setStatoPrenotazione(false);
		request.setHotel(hotel);
		
		response = h.aggiornaCameraREST(request);
		
		assertEquals(0, response.getValueError());
		
		//fare stato prenotazione true
		//fare stanza richiesta già occupata
		//mettere hotel.statopren false
	}
}
