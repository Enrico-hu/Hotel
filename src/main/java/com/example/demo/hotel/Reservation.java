package com.example.demo.hotel;

import java.util.Date;
import java.util.logging.Logger;

public class Reservation {
	
	private double numeroRegistrazione;
	private String nomePrenotazione;
	private int numeroStanzaPrenotata;
	private Date dataArrivo;
	private Date dataPartenza;
	private boolean pagamentoEffettuato;
	private boolean prenotazioneConfermata;
	private boolean flagEffettuaPagamento;
	private String error;
	private int errorValue;
	
	
	public Reservation creaPrenotazione (Reservation prenotazione, String nomePrenotazione, Date dataArrivo, Date dataPartenza, boolean flagPagamento) {
		
		prenotazione.setNumeroRegistrazione((int) (Math.random()*100000)+1);
		prenotazione.setDataArrivo(dataArrivo);

		prenotazione.setNomePrenotazione(nomePrenotazione);
		prenotazione.setFlagEffettuaPagamento(flagPagamento);
		
		if(dataPartenza.before(dataArrivo)) {
			error= ("La data di partenza non pu� essere precendente a quella di arrivo! Inserisci un'altra data\n");
			errorValue = 1;
			prenotazione.errorValue=errorValue;
			prenotazione.error = error;
			return prenotazione;
		} 
		
		prenotazione.setDataPartenza(dataPartenza);
		
		return prenotazione;
	}
	
	public void confermaPrenotazione (Reservation prenotazione) {
		
		if(prenotazione.isPrenotazioneConfermata()) {
			Logger.getGlobal().info("\nGentile " + prenotazione.getNomePrenotazione() + ", la tua prenotazione nr. " + prenotazione.getNumeroRegistrazione() + " � stata effettuata con successo!");
			prenotazione.setPrenotazioneConfermata(true);
			if(flagEffettuaPagamento) {
				prenotazione.effettuaPagamento(prenotazione);
			}
			else {
				prenotazione.setPagamentoEffettuato(false);
				Logger.getGlobal().info("\nEffettuerai il pagamento direttamente in struttura!\nGrazie per la prenotazione");
			}
		
		} else {
			prenotazione.setPrenotazioneConfermata(false);
			prenotazione.setError("Prenotazione non andata a buon fine\n");
			prenotazione.setErrorValue(1);
		}
		


	}
	
	public void effettuaPagamento (Reservation prenotazione) {
		
		prenotazione.setPagamentoEffettuato(true);
		Logger.getGlobal().info("\nPagamento effettuato con successo! Non vediamo l'ora di averti come ospite! \nGrazie");
		
	}
	
//	public String nomePrenotazione() {
//		
//		try{
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			nomePrenotazione = reader.readLine();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return nomePrenotazione;
//	}
//	
//	public Date dataArrivo() throws ParseException {
//				
//		Logger.getGlobal().info("Inserisci data di arrivo\n");
//		
//		try{
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return dataArrivo;
//	}
//	
//	public Date dataPartenza(Date dataArrivo) throws ParseException {
//		
//		boolean dataPartenzaValida = false;
//		
//		while(!dataPartenzaValida) {
//			Logger.getGlobal().info("Inserisci data di partenza\n");
//			try{
//				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//				dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
//				if(dataPartenza.before(dataArrivo)) {
//					Logger.getGlobal().info("La data di partenza non pu� essere precendente a quella di arrivo! Inserisci un'altra data\n");
//				} else {
//					dataPartenzaValida=true;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		//riadattare i punti con il buffer - ricevere info dall'input come parametro
//		
//		return dataPartenza;
//	}
	
	public double getNumeroRegistrazione() {
		return numeroRegistrazione;
	}
	public void setNumeroRegistrazione(double numeroRegistrazione) {
		this.numeroRegistrazione = numeroRegistrazione;
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
	public boolean isPagamentoEffettuato() {
		return pagamentoEffettuato;
	}
	public void setPagamentoEffettuato(boolean pagamentoEffettuato) {
		this.pagamentoEffettuato = pagamentoEffettuato;
	}

	public boolean isPrenotazioneConfermata() {
		return prenotazioneConfermata;
	}

	public void setPrenotazioneConfermata(boolean prenotazioneConfermata) {
		this.prenotazioneConfermata = prenotazioneConfermata;
	}

	public boolean isFlagEffettuaPagamento() {
		return flagEffettuaPagamento;
	}

	public void setFlagEffettuaPagamento(boolean flagEffettuaPagamento) {
		this.flagEffettuaPagamento = flagEffettuaPagamento;
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

	public int getNumeroStanzaPrenotata() {
		return numeroStanzaPrenotata;
	}

	public void setNumeroStanzaPrenotata(int numeroStanzaPrenotata) {
		this.numeroStanzaPrenotata = numeroStanzaPrenotata;
	}
	
}
