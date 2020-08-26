package com.example.demo.om;

import java.util.Date;

import com.example.demo.hotel.Hotel;

public class PrenotaRequest {

	private Hotel hotel;
	private String nomePrenotazione;
	private Date dataArrivo;
	private Date dataPartenza;
	private boolean flagPagamento;
	private int cameraRichiesta;
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getNomePrenotazione() {
		return nomePrenotazione;
	}
	public void setNomePrenotazione(String nomePrenotazione) {
		this.nomePrenotazione = nomePrenotazione;
	}
	public Date getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public Date getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public boolean isFlagPagamento() {
		return flagPagamento;
	}
	public void setFlagPagamento(boolean flagPagamento) {
		this.flagPagamento = flagPagamento;
	}
	public int getCameraRichiesta() {
		return cameraRichiesta;
	}
	public void setCameraRichiesta(int cameraRichiesta) {
		this.cameraRichiesta = cameraRichiesta;
	}
}
