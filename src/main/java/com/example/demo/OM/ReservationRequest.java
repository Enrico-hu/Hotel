package com.example.demo.OM;

import com.example.demo.hotel.Reservation;
import java.util.Date;

public class ReservationRequest {
	private Reservation prenotazione;
	private String nomePrenotazione;
	private Date dataArrivo;
	private Date dataPartenza;
	private boolean flagPagamento;
	private String error;
	private int cameraPrenotata;
	private int valueError;
	
	
	
	public Reservation getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(Reservation prenotazione) {
		this.prenotazione = prenotazione;
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
	public int getCameraPrenotata() {
		return cameraPrenotata;
	}
	public void setCameraPrenotata(int cameraPrenotata) {
		this.cameraPrenotata = cameraPrenotata;
	}
	
}
