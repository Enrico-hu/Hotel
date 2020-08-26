package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.Hotel;
import com.example.demo.om.AggiornaCameraRequest;
import com.example.demo.om.AggiornaCameraResponse;
import com.example.demo.om.CreaHotelResponse;


@RestController
@RequestMapping(value="/hotel")
public class HotelREST {

	@GetMapping(value="/creaHotel")
	public CreaHotelResponse creaHotelREST() {

		Hotel hotel = new Hotel();
		CreaHotelResponse response = new CreaHotelResponse();
		response.setValueError(0);
		String test = "Ho modificato";
		
		hotel.creaHotel(hotel);
		response.setHotel(hotel);

		return response;		
	}
	
	@PostMapping(value="/aggiornaCamera")
	public AggiornaCameraResponse aggiornaCameraREST(@RequestBody AggiornaCameraRequest request) {
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		int stanzaPrenotata = request.getPrenotazione().getNumeroStanzaPrenotata();
		
		response.setValueError(0);
		response.setHotel(request.getHotel());
		
		if(request.isStatoPrenotazione()) {
			response.setValueError(1);
			response.setError("Prenotazione già confermata");
			return response;
		}
		
		if(response.getHotel()!=null && !response.getHotel().getStanzeHotel()[stanzaPrenotata].isLibera()) {
				response.setValueError(1);
				response.setError("Stanza già prenotata");
				return response;
		}
		
		request.getHotel().aggiornaCamera(request.getHotel(), request.getPrenotazione(), request.isStatoPrenotazione());
		response.setStatoPrenotazione(request.getHotel().isStatoPrenotazione());
		
		if(!response.isStatoPrenotazione()) {
			response.setValueError(1);
			response.setError("Prenotazione non andata a buon fine");
			return response;
		}
		
		return response;	
	}
}
