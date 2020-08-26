package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.Room;
import com.example.demo.om.PrenotaRequest;
import com.example.demo.om.PrenotaResponse;

@RestController
@RequestMapping(value="/stanza")
public class RoomREST {
	
	@PostMapping(value="/prenota")
	public PrenotaResponse prenota(@RequestBody PrenotaRequest request) {
		PrenotaResponse response = new PrenotaResponse();
		response.setValueError(0);
		
		response.setPrenotazione(Room.prenota(request.getHotel(), request.getNomePrenotazione(), request.getDataArrivo(), request.getDataPartenza(), request.isFlagPagamento(), request.getCameraRichiesta()));
		
		if(response.getPrenotazione()==null) {
			response.setError("Prenotazione inesistente");
			response.setValueError(1);
			return response;
		} else if(response.getPrenotazione().getErrorValue()>0) {
			response.setValueError(1);
			response.setError(response.getPrenotazione().getError());
			return response;
		}
		
		
		return response;		
	}
}
