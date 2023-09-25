package org.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// --------------INIZIALIZZAZIONE VARIABILI-------------
		String titolo = null;
		LocalDate data;
		int numeroPrenotazioni;
		int numeroPrenotazioniDaCancellare;
		int numeroDiPosti;
		// -----------------------------------------------

		// -------------SET TITOLO---------------
		Scanner input = new Scanner(System.in);
		System.out.println("Crea un nuovo emento!");
		System.out.print("Inserisci un titolo:");
		titolo = input.nextLine();
		// -----------------------------------------------

		// ---------------SET DATA-----------------
		System.out.print("Inserisci una data (AAAA-MM-GG): ");
		String dataString = input.nextLine();
		data = LocalDate.parse(dataString);
		// -----------------------------------------------

		// ----------------SET NUMERO POSTI-----------------------
		System.out.print("Inserisci il numero di posti:");
		numeroDiPosti = Integer.valueOf(input.nextLine());
		// -----------------------------------------------

		
		
		try {
			// -------------- SET NUOVO EVENTO------------------
			Evento nuovoEvento = new Evento(titolo, data, numeroDiPosti);
			boolean condizione = true;
			// -----------------------------------------------

			
			// -------------------NUOVA PRENOTAZIONE--------------------
			while (condizione) {
				System.out.print("vuoi effetuare prenotazioni per l'evento? Y/n ?");
				String choise = input.nextLine();
				if (choise.equals("Y")) {
					
					System.out.print("Quante prenotazioni vuoi effetuare?");
					numeroPrenotazioni = Integer.valueOf(input.nextLine());
					for (int i = 0; i < numeroPrenotazioni; i++) {
						nuovoEvento.prenota();
					}
					condizione = false;
				} else if (choise.equals("n")) {
					condizione = false;

				} else {
					System.out.println("1 scelta non chiara , riprova!");
				}
			}
			// -----------------------------------------------

			// ----------------RESET CONDIZIONE E PRINT INFO-------------------
			condizione = true;
			System.out.println("posti totali : " + nuovoEvento.getNumeroPostiTotali() + "posti disponibili : "
					+ (nuovoEvento.getNumeroPostiTotali() - nuovoEvento.getNumeroPostiPrenotati()));
			String choise2="inizio";
			// -----------------------------------------------

			// ------------------NUOCA DIDETTA----------------------------
			while (condizione) {
				System.out.print("vuoi disdire prenotazioni per l'evento? Y/n ?");
				 choise2 = input.nextLine();
				
				if (choise2.equals("Y")) {
					
					System.out.print("Quante prenotazioni vuoi disdire?");
					numeroPrenotazioniDaCancellare = Integer.valueOf(input.nextLine());
					for (int i = 0; i < numeroPrenotazioniDaCancellare; i++) {
						nuovoEvento.disdici();
					}
					condizione = false;
				} else if (choise2.equals("n")) {
					condizione = false;
				} else {
					System.out.println(choise2);
					System.out.println("2 scelta non chiara , riprova!");
				}
			}
			// -----------------------------------------------

			// ---------------PRINT INFO------------------------
			System.out.println("posti totali : " + nuovoEvento.getNumeroPostiTotali() + "posti disponibili : "
					+ (nuovoEvento.getNumeroPostiTotali() - nuovoEvento.getNumeroPostiPrenotati()));
			// -----------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		input.close();
		
		
		//-----------------------------------------------
		List<Evento> eventi = null  ;
		try {
			eventi.add( new Concerto("concerto1",data, 54,12, 60,23,
					 new BigDecimal("10.25")));
			eventi.add(new Concerto("concerto2",data, 54,12, 60,23,
					 new BigDecimal("10.25")));
			eventi.add(new Concerto("concerto3",data, 54,12, 60,23,
					 new BigDecimal("10.25")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProgammEventi Programma = new ProgammEventi("Progromma", eventi);
		System.out.println(Programma.numeroEventi());
		System.out.println(Programma);
		Programma.suovaListaEventi();
		
	}
}
