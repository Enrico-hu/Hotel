package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OM.ReservationRequest;
import com.example.demo.OM.ReservationResponse;


@RestController
@RequestMapping(value="/prenotazione")
public class ReservationREST {

	@PostMapping(value="/creaPrenotazione")
	public ReservationResponse creaPrenotazione(@RequestBody ReservationRequest request) {
		
		ReservationResponse response = new ReservationResponse();

		response.setPrenotazione(request.getPrenotazione());
		response.getPrenotazione().setNumeroRegistrazione((int) (Math.random()*100000)+1);
		response.getPrenotazione().setNomePrenotazione(request.getNomePrenotazione());
		response.getPrenotazione().setDataArrivo(request.getDataArrivo());
		
			
		if(request.getDataPartenza().before(request.getDataArrivo())) {
			response.getPrenotazione().setError("La data di partenza non puo' essere precendente a quella di arrivo!");
			response.getPrenotazione().setErrorValue(1);
			return response;
		} 
		
		response.getPrenotazione().setDataPartenza(request.getDataPartenza());
		
		return response;		
	}
	
	
}
