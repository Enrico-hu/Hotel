package com.example.demo.hotel;

import java.util.Date;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {

		Hotel hotel = new Hotel();
		hotel.creaHotel(hotel);
		String nomePrenotazione = "Enrico";
		Date dataArrivo = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2020");
		Date dataPartenza = new SimpleDateFormat("dd/MM/yyyy").parse("03/09/2020");
		boolean flagPagamento = true;
		int camera = 2;
		
		Logger.getGlobal().info("Benvenuto nell'hotel di Enrico!\n");
				
		Room.prenota(hotel, nomePrenotazione, dataArrivo, dataPartenza, flagPagamento, camera);
		
		Logger.getGlobal().info("Buona giornata! A presto");
			
	}
}
