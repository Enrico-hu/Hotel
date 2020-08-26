package com.example.demo.hotel;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.example.demo.om.PrenotaRequest;
import com.example.demo.om.PrenotaResponse;
import com.example.demo.web.RoomREST;

public class TestRoomRest {

	@Test
	public void prenotaREST() throws ParseException {
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		PrenotaRequest request = new PrenotaRequest();
		PrenotaResponse response = new PrenotaResponse();
		RoomREST r = new RoomREST();
		
		request.setHotel(hotel);
		request.setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.setFlagPagamento(true);
		request.setNomePrenotazione("Enrico");
		request.setCameraRichiesta(2);
		
		response = r.prenota(request);
		
		assertEquals(0, response.getPrenotazione().getErrorValue());

	}
	
	@Test
	public void prenotaRESTCameraErrata() throws ParseException {
		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		
		PrenotaRequest request = new PrenotaRequest();
		PrenotaResponse response = new PrenotaResponse();
		RoomREST r = new RoomREST();
		
		request.setHotel(hotel);
		request.setDataArrivo(new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
		request.setDataPartenza(new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2020"));
		request.setFlagPagamento(true);
		request.setNomePrenotazione("Enrico");
		request.setCameraRichiesta(10);
		
		response = r.prenota(request);
		
		assertEquals(1, response.getPrenotazione().getErrorValue());

	}

}
