package org.java.eventi;

import java.time.LocalDate;
import java.util.Date;

public class Evento {

	// ---------------Variabili-----------------------
	private LocalDate dataAttuale = LocalDate.now();
	private String titolo;
	private LocalDate data;
	private int numeroPostiTotali;
	private int numeroPostiPrenotati;
	// -----------------------------------------------

	// -------------Funzioni--------------------
	public void prenota() throws Exception {
		if (this.numeroPostiPrenotati < this.numeroPostiTotali) {
			if (!this.data.isAfter(dataAttuale) || !this.data.isEqual(dataAttuale))
				this.setNumeroPostiPrenotati(this.numeroPostiPrenotati + 1);
			else {
				throw new Exception("non puoi piu prenotare per questo spettacolo, è ggia passato");
			}
		} else {
			throw new Exception("non ci sono piu posti liberi");
		}
	}

	public void disdici() throws Exception {

		if (!this.data.isBefore(dataAttuale)) {
			if (this.numeroPostiPrenotati >= 1) {
				this.setNumeroPostiPrenotati(this.numeroPostiPrenotati - 1);

			} else {
				throw new Exception("non ci sono prenotazioni");

			}
		} else {
			throw new Exception("non puoi piu disdire per questo spettacolo, è ggia passato");

		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  this.data + " - " + this.titolo;
	}
	// -----------------------------------------------

	// --------------Costruttore--------------------------
	public Evento(String titolo, Date data, int numeroPostiTotali) throws Exception {
		this.setTitolo(titolo);
		this.setNumeroPostiPrenotati(0);
		this.setNumeroPostiTotali(numeroPostiTotali);
	}
	// -----------------------------------------------

	// -------------SET e GET----------------
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		if (data.isAfter(dataAttuale)) {
			this.data = data;
		} else if (data.isEqual(dataAttuale)) {
			throw new Exception("l'evento non puo essere organizzato oggi");
		} else {
			throw new Exception("la data non puo essere di un giorno gia passato");
		}
	}

	public int getNumeroPostiTotali() {
		return numeroPostiTotali;
	}

	private void setNumeroPostiTotali(int numeroPostiTotali) throws Exception {
		if (numeroPostiTotali > 0) {
			this.numeroPostiTotali = numeroPostiTotali;
		} else {
			throw new Exception("Il numero di posti non puo essere negativo");
		}
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}

	private void setNumeroPostiPrenotati(int numeroPostiPrenotati) {
		this.numeroPostiPrenotati = numeroPostiPrenotati;
	}
	// -----------------------------------------------

}