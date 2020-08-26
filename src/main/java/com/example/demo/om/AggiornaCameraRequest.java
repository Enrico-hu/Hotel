package com.example.demo.om;

import com.example.demo.hotel.Hotel;
import com.example.demo.hotel.Reservation;

public class AggiornaCameraRequest {

	private Hotel hotel;
	private Reservation prenotazione;
	private boolean statoPrenotazione;
	private String error;
	private int valueError;
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Reservation getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(Reservation prenotazione) {
		this.prenotazione = prenotazione;
	}
	public boolean isStatoPrenotazione() {
		return statoPrenotazione;
	}
	public void setStatoPrenotazione(boolean statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
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
