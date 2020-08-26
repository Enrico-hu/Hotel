package com.example.demo.hotel;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.example.demo.om.ReservationRequest;
import com.example.demo.om.ReservationResponse;
import com.example.demo.web.ReservationREST;

public class TestReservationRest {

	@Test
	public void testCreaPrenotazioneREST() throws ParseException {
		
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		
		ReservationRequest request = new ReservationRequest();
		ReservationResponse response = new ReservationResponse();
		ReservationREST res = new ReservationREST();
		
		request.setPrenotazione(new Reservation());
		request.setCameraPrenotata(1);
		request.setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.setFlagPagamento(true);
		request.setNomePrenotazione("Enrico");
		
		response = res.creaPrenotazione(request);
		
		assertEquals("Enrico", response.getPrenotazione().getNomePrenotazione());
		assertEquals(request.getDataArrivo(), response.getPrenotazione().getDataArrivo());
		assertEquals(request.getDataPartenza(), response.getPrenotazione().getDataPartenza());
		assertEquals(request.getCameraPrenotata(), response.getPrenotazione().getNumeroStanzaPrenotata());
		assertEquals("Enrico", response.getPrenotazione().getNomePrenotazione());
		assertEquals(0, response.getPrenotazione().getErrorValue());
	}

	@Test
	public void testCreaPrenotazioneRESTDateErrate() throws ParseException {
		
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		
		ReservationRequest request = new ReservationRequest();
		ReservationResponse response = new ReservationResponse();
		ReservationREST res = new ReservationREST();
		
		request.setPrenotazione(new Reservation());
		request.setCameraPrenotata(1);
		request.setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2020"));
		request.setFlagPagamento(true);
		request.setNomePrenotazione("Enrico");
		
		response = res.creaPrenotazione(request);
		
		assertEquals(1, response.getPrenotazione().getErrorValue());
	}
}
