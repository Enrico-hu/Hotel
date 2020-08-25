package com.example.demo.OM;

import com.example.demo.hotel.Hotel;

public class AggiornaCameraResponse {

	private Hotel hotel;
	private boolean statoPrenotazione;
	private String error;
	private int valueError;
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	public boolean isStatoPrenotazione() {
		return statoPrenotazione;
	}
	public void setStatoPrenotazione(boolean statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}
	
}
