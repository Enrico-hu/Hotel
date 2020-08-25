package com.example.demo.hotel;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestReservation {

	@Test
	public void testCreaPrenotazione() throws ParseException {
		String nome = "Enrico";
		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020");
		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("22/08/2020");
		boolean flagPagamento = true;
		
		Reservation p = new Reservation();
		
		p.creaPrenotazione(p, nome, dataArrivo, dataPartenza, flagPagamento);
		assertEquals(nome, p.getNomePrenotazione());
		assertEquals(dataArrivo, p.getDataArrivo());
		assertEquals(dataPartenza, p.getDataPartenza());
		assertEquals(true, p.isFlagEffettuaPagamento());
	}
	
	@Test
	public void testCreaPrenotazionePost() throws ParseException {
		String nome = "Enrico";
		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020");
		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2020");
		boolean flagPagamento = true;
		
		Reservation p = new Reservation();
		
		p.creaPrenotazione(p, nome, dataArrivo, dataPartenza, flagPagamento);
		assertEquals(nome, p.getNomePrenotazione());
		assertEquals(dataArrivo, p.getDataArrivo());
		assertEquals(true, p.isFlagEffettuaPagamento());
		assertEquals(1, p.getErrorValue());
	}
	
//	@Test
//	public void testNomePrenotazione() {		
//		Reservation p = new Reservation();
//		
//		String out = p.nomePrenotazione();
//		assertEquals("enrico", out);
//		
//	}
//	
//	@Test
//	public void testDataArrivo() throws ParseException {		
//		Reservation p = new Reservation();
//		
//		Date out = p.dataArrivo();
//		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020");
//		
//		assertEquals(dataArrivo, out);
//		
//	}
//	
//	@Test
//	public void testDataPartenza() throws ParseException {		
//		Reservation p = new Reservation();
//		
//		Date dataArrivoPre = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020");
//		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("22/08/2020");
//		
//		Date out = p.dataPartenza(dataArrivoPre);
//		assertEquals(dataPartenza, out);
//		
//	}
	
	@Test
	public void testConfermaPrenotazioneFalse() {		
		Reservation p = new Reservation();
		
		p.setPrenotazioneConfermata(false);
		
		p.confermaPrenotazione(p);
		assertEquals(false, p.isPrenotazioneConfermata());
		
	}
	
	@Test
	public void testConfermaPrenotazioneTrue() {		
		Reservation p = new Reservation();
		
		p.setPrenotazioneConfermata(true);
		p.setNomePrenotazione("Enrico");
		p.setNumeroRegistrazione(1);
		p.confermaPrenotazione(p);
		
		assertEquals(true, p.isPrenotazioneConfermata());

		
	}
	
	@Test
	public void testConfermaPrenotazioneTrue2() {		
		Reservation p = new Reservation();
		
		p.setPrenotazioneConfermata(true);
		p.setNomePrenotazione("Enrico");
		p.setNumeroRegistrazione(1);
		p.setFlagEffettuaPagamento(true);
		p.confermaPrenotazione(p);
		
		assertEquals(true, p.isPrenotazioneConfermata());
		assertEquals(true, p.isPagamentoEffettuato());

		
	}
	
	@Test
	public void effettuaPagamento() {		
		Reservation p = new Reservation();
		
		p.setPagamentoEffettuato(true);
		p.setPrenotazioneConfermata(true);
		p.setNomePrenotazione("Enrico");
		p.setNumeroRegistrazione(1);
		
		p.effettuaPagamento(p);
		
		assertEquals(true, p.isPagamentoEffettuato());
		
	}

}
