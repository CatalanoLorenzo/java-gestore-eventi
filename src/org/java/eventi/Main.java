package org.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		String titolo = null;
		LocalDate data;
		int numeroDiPosti;

		Scanner input = new Scanner(System.in);
		System.out.println("Crea un nuovo emento!");
		System.out.print("Inserisci un titolo:");
		titolo = input.nextLine();

		System.out.print("Inserisci una data (AAAA-MM-GG): ");
		String dataString = input.nextLine();
		LocalDate dataInserita = LocalDate.parse(dataString);
		System.out.print("Inserisci il numero di giorni da aggiungere: ");
		int giorniDaAggiungere = input.nextInt();
		data = dataInserita.plusDays(giorniDaAggiungere);

		System.out.print("Inserisci il numero di posti:");
		numeroDiPosti = input.nextInt();
		
		try {
			Evento nuovoEvento = new Evento(titolo, data, numeroDiPosti);
			System.out.print("vuoi effetuare prenotazioni per l'evento? Y/n ?");
			String choise = input.nextLine();
			while(true) {
				if (choise.equals("Y")) {
					System.out.print("Quante prenotazioni vuoi effetuare?");
					int numeroPrenotazioni = input.nextInt();
					for (int i = 0; i < numeroPrenotazioni; i++) {
						nuovoEvento.prenota();						
					}					
				}else if (choise.equals("n")) {
					break;
				}else {
					System.out.println("scelta non chiara , riprova!");
				}
			}
			System.out.println("posti totali : " + nuovoEvento.getNumeroPostiTotali() + "posti prenotati : " + nuovoEvento.getNumeroPostiPrenotati());
			System.out.print("vuoi disdire prenotazioni per l'evento? Y/n ?");
			String choise2 = input.nextLine();
			while(true) {
				if (choise2.equals("Y")) {
					System.out.print("Quante prenotazioni vuoi disdire?");
					int numeroPrenotazioni = input.nextInt();
					for (int i = 0; i < numeroPrenotazioni; i++) {
						nuovoEvento.disdici();						
					}
					
				}else if (choise2.equals("n")) {
					break;
				}else {
					System.out.println("scelta non chiara , riprova!");
				}
			}
			System.out.println("posti totali : " + nuovoEvento.getNumeroPostiTotali() + "posti prenotati : " + nuovoEvento.getNumeroPostiPrenotati());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
