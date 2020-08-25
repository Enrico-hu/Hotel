package com.example.demo.OM;

import com.example.demo.hotel.Reservation;

public class PrenotaResponse {

	private Reservation prenotazione;
	private String error;
	private int valueError;
	
	
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
	public int getValueError() {
		return valueError;
	}
	public void setValueError(int valueError) {
		this.valueError = valueError;
	}
}
