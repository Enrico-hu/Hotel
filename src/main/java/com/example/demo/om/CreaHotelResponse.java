package com.example.demo.om;

import com.example.demo.hotel.Hotel;

public class CreaHotelResponse {

	private Hotel hotel;
	private String error;
	private int valueError; //se torna 1 allora c'è un errore - TS in rosso
	
	
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
}
