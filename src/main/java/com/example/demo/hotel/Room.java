package com.example.demo.hotel;

import java.util.Date;

public class Room {
	private int numeroStanza;
	private int piano;
	private int numeroLetti;
	private boolean libera;
	private Reservation prenotazione;
	private String error;
	private int errorValue;
	
	
	public void creaStanza(Room stanza, int numeroStanza, int piano, int numeroLetti) {
	
		stanza.setPiano(piano);
		stanza.setNumeroStanza(numeroStanza);
		stanza.setNumeroLetti(numeroLetti);
		stanza.setLibera(true);
	
	}
	
	//il metodo aggiorna il numero delle stanze libere nell'hotel e restituisce una prenotazione
	public static Reservation prenota (Hotel hotel, String nomePrenotazione, Date dataArrivo, Date dataPartenza, boolean flagPagamento) {
		
		Reservation prenotazione = new Reservation();	
		int cameraRichiesta = 3;
		
		prenotazione.creaPrenotazione(prenotazione, nomePrenotazione, dataArrivo, dataPartenza, flagPagamento);		

		if(prenotazione.getErrorValue()>0) {
			return prenotazione;
		}
			
		if(cameraRichiesta<Hotel.numeroCamere) {
			prenotazione.setNumeroStanzaPrenotata(cameraRichiesta);
			hotel = hotel.aggiornaCamera(hotel, prenotazione, false);
			if(hotel.isStatoPrenotazione()) {
				hotel.getStanzeHotel()[cameraRichiesta].setPrenotazione(prenotazione);
				prenotazione.setNumeroStanzaPrenotata(cameraRichiesta);
				prenotazione.setPrenotazioneConfermata(true);	
			}	
		}
		else {
			prenotazione.setError("\nNon esiste la stanza richiesta. Riprovare.");
			prenotazione.setErrorValue(1);
			return prenotazione;
		}
		
		prenotazione.confermaPrenotazione(prenotazione);
		
		return prenotazione;
		
	}

	public int getNumeroStanza() {
		return numeroStanza;
	}

	public void setNumeroStanza(int numeroStanza) {
		this.numeroStanza = numeroStanza;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public int getNumeroLetti() {
		return numeroLetti;
	}

	public void setNumeroLetti(int numeroLetti) {
		this.numeroLetti = numeroLetti;
	}

	public boolean isLibera() {
		return libera;
	}

	public void setLibera(boolean libera) {
		this.libera = libera;
	}

	public Reservation getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Reservation prenotazione) {
		this.prenotazione = prenotazione;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getErrorValue() {
		return errorValue;
	}

	public void setErrorValue(int errorValue) {
		this.errorValue = errorValue;
	}
}
