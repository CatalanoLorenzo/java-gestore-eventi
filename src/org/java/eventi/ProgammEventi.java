package org.java.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgammEventi {

	// ---------------VARIABILI-----------------------
	private String titolo;
	private List<Evento> eventi;
	// -----------------------------------------------

	// ----------------COSTRUTTORE----------------------
	public ProgammEventi(String titolo, List<Evento> eventi) {
		this.eventi = new ArrayList<Evento>();
		this.setTitolo(titolo);
	}
	// -----------------------------------------------

	// ----------------GET E SET--------------
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	// -----------------------------------------------

	// ----------------FUNZIONI---------------------
	public BigDecimal mediaPrezzoConcerto(List<Concerto> listaConcerti) {
		int i=0;
		BigDecimal somma = null;
		for (Concerto concerto : listaConcerti) {
			somma = somma.add(concerto.getPrezzo());
			i++;
		}
	    BigDecimal media = somma.divide(BigDecimal.valueOf(listaConcerti.size()), 2, RoundingMode.HALF_UP);
		return media;
	}
	public BigDecimal mediaPrezzoSpettacolo(List<Spettacolo> listaSpettacolo) {
		int i=0;
		BigDecimal somma = null;
		for (Spettacolo spettacolo : listaSpettacolo) {
			somma = somma.add(spettacolo.getPrezzo());
			i++;
		}
	    BigDecimal media = somma.divide(BigDecimal.valueOf(listaSpettacolo.size()), 2, RoundingMode.HALF_UP);
		return media;
	}
	public BigDecimal mediaPrezzoEvento(List<Evento> listaEvento) {
		int i=0;
		BigDecimal somma = null;
		for (Evento evento : listaEvento) {
			if(somma.add(((Concerto) evento).getPrezzo())!= null) {
				somma = somma.add(((Concerto) evento).getPrezzo());
			}else {
				somma = somma.add(((Spettacolo) evento).getPrezzo());

			}
			i++;
		}
	    BigDecimal media = somma.divide(BigDecimal.valueOf(listaEvento.size()), 2, RoundingMode.HALF_UP);
		return media;
	}
	public void aggiungiEvento(Evento evento) {
		this.eventi.add(evento);
	}

	@SuppressWarnings("null")
	public List<Evento> listaEventiPerData(LocalDate data) {
		List<Evento> listaEventi = null;
		for (Evento evento : this.eventi) {
			if (evento.getData() == data) {
				listaEventi.add(evento);
			}

		}
		return listaEventi;
	}

	public int numeroEventi() {
		return this.eventi.size();
	}

	public void suovaListaEventi() {
		this.eventi.clear();
	}

	@SuppressWarnings({ "null", "unchecked" })
	public String ProgrammString() {

		String stringaEvento = this.titolo + "\n";
		 List <Evento> [] eventiordinato = null ;
		 int counterOrdinato = 0;
		 for (Evento evento : eventi) {
			 if(((Evento) evento).getData().isAfter (((Evento) eventiordinato[counterOrdinato]).getData())) {
				 eventiordinato[counterOrdinato]= (List<Evento>) evento;
				 counterOrdinato++;
			 }
		}

		for (List<Evento> evento : eventiordinato) {

			stringaEvento += ((Evento) evento).getData() + " - " + ((ProgammEventi) evento).getTitolo() + "\n";

		}
		return stringaEvento;
	}
	// -----------------------------------------------

}
