package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OM.CreaHotelResponse;
import com.example.demo.OM.AggiornaCameraRequest;
import com.example.demo.OM.AggiornaCameraResponse;
import com.example.demo.hotel.Hotel;


@RestController
@RequestMapping(value="/hotel")
public class HotelREST {

	@GetMapping(value="/creaHotel")
	public CreaHotelResponse prenotaREST() {

		Hotel hotel = new Hotel();
		CreaHotelResponse response = new CreaHotelResponse();
		response.setValueError(0);
		
		hotel.creaHotel(hotel);
		response.setHotel(hotel);
		
		if(response.getHotel()==null) {
			response.setValueError(1);
			response.setError("Hotel null");
		}

		return response;		
	}
	
	@PostMapping(value="/aggiornaCamera")
	public AggiornaCameraResponse aggiornaCameraREST(@RequestBody AggiornaCameraRequest request) {
		AggiornaCameraResponse response = new AggiornaCameraResponse();
		int stanzaPrenotata = request.getPrenotazione().getNumeroStanzaPrenotata();
		
		response.setValueError(0);
		
		if(request.isStatoPrenotazione()) {
			response.setValueError(1);
			response.setError("Prenotazione già confermata");
			return response;
		}
		
		request.getHotel().aggiornaCamera(request.getHotel(), request.getPrenotazione(), request.isStatoPrenotazione());
		
		response.setHotel(request.getHotel());
		response.setStatoPrenotazione(request.getHotel().isStatoPrenotazione());
		
		
		if(response.getHotel()!=null) {
			if(response.getHotel().getStanzeHotel()[stanzaPrenotata].isLibera() || !response.getHotel().isStatoPrenotazione()) {
				response.setValueError(1);
				response.setError("Stanza già prenotata");
				return response;
			} 
		}
		
		if(!response.isStatoPrenotazione()) {
			response.setValueError(1);
			response.setError("Prenotazione non andata a buon fine");
			return response;
		}
		
		return response;	
	}
}
