package org.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgammEventi {

	private String titolo;
	private List<Evento> eventi;

	public ProgammEventi(String titolo, List<Evento> eventi) {
		this.eventi = new ArrayList<Evento>();
		this.setTitolo(titolo);
	}

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

	public String ProgrammString() {

		String stringaEvento = this.titolo + "\n";
		for (Evento evento : eventi) {

			stringaEvento += evento.getData() + " - " + evento.getTitolo() + "\n";

		}
		return stringaEvento;
	}
}
