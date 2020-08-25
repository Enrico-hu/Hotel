package com.example.demo.hotel;

import java.util.logging.Logger;

public class Hotel {
	private Room[] stanzeHotel; //hotel � un insieme di camere che possono essere libere o occupate
	public static int numeroCamere = 5; //hotel ha un numero massimo di camere (ad ogni numero corrisponde una psozione sull'array)
	private boolean statoPrenotazione;
	
	public void creaHotel(Hotel hotel) {
		
		
		hotel.stanzeHotel = new Room[numeroCamere];
		for(int i = 0; i< numeroCamere; i++) {		
			hotel.stanzeHotel[i] = new Room();
			hotel.stanzeHotel[i].creaStanza(hotel.stanzeHotel[i], i, (int) (Math.random()*3)+1, (int) (Math.random()*3)+1);
		}
			
	}
	
	public Hotel aggiornaCamera (Hotel hotel, Reservation prenotazione, boolean statoPrenotazione) {
		
		if(statoPrenotazione) {
			Logger.getGlobal().info("\nPrenotazione già attiva!");
			hotel.setStatoPrenotazione(statoPrenotazione);
			return hotel;
		}

		//controllo la disponibilità dell'hotel Se è pieno mi restituisce un false e restituisce uno statoPrenotazione false
		if(!controllaDisponibilita(hotel)) {
			hotel.setStatoPrenotazione(statoPrenotazione);
			return hotel;
		}
		
		
		if (!hotel.getStanzeHotel()[prenotazione.getNumeroStanzaPrenotata()].isLibera()) {
			Logger.getGlobal().info("\nCamera non disponibile! Prova con un'altra camera!");
			statoPrenotazione = false;
			hotel.setStatoPrenotazione(statoPrenotazione);
			return hotel;
		}
		else {
			Logger.getGlobal().info("\nPrenotazione confermata!");
			statoPrenotazione = true;
			hotel.getStanzeHotel()[prenotazione.getNumeroStanzaPrenotata()].setLibera(false);
			hotel.setStatoPrenotazione(statoPrenotazione);
			return hotel;
		}
	}
	
//	private boolean cancellaPrenotazione (Room stanza, boolean statoPrenotazione) {
//		
//		//se la stanza non � libera, elimina i dati della stanza e la setta come libera
//		if (!this.stanzeHotel[stanza.getNumeroStanza()].isLibera()) {
//			this.stanzeHotel[stanza.getNumeroStanza()].setLibera(true);;
//		} else {
//			Logger.getGlobal().info("\nPrenotazione gi� cancellata per la camera selezionata!");			
//		}
//		
//		statoPrenotazione = true;
//		return statoPrenotazione;
//	}

	private boolean controllaDisponibilita(Hotel hotel) {
		boolean hotelLibero = true;
		
		
		for(int i=0; i<this.stanzeHotel.length; i++) {
					
			if(hotel.getStanzeHotel()[i].isLibera()) {
				hotelLibero = true;
				break;
			} else {
				hotelLibero = false;
			}
		}
		
		if(!hotelLibero) {
			Logger.getGlobal().info("\nHotel al completo! Mi dispiace!");
			
		}
		
		return hotelLibero;//se l'hotel è pieno restituice un false
	}

	public Hotel() {};
	
	
	public Room[] getStanzeHotel() {
		return stanzeHotel;
	}


	public void setStanzeHotel(Room[] stanzeHotel) {
		this.stanzeHotel = stanzeHotel;
	}

	public boolean isStatoPrenotazione() {
		return statoPrenotazione;
	}

	public void setStatoPrenotazione(boolean statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}

}
