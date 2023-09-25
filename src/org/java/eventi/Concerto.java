package org.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

	// ----------------VARIABILI-------------------------
	private LocalTime ora;
	private BigDecimal prezzo;
	private String prezzoFormattato;
	private String oraFormattata;
	// -----------------------------------------------

	// ------------------COSTRUTTORE------------------
	public Concerto(String titolo, LocalDate data, int numeroPostiTotali, int ore, int minuti, int secondi,
			BigDecimal prezzo) throws Exception {
		super(titolo, data, numeroPostiTotali);
		this.setOra(ore, minuti, secondi);
		this.setPrezzo(prezzo);
	}
	// -----------------------------------------------

	// ------------------SET E GET-------------------
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(int ora, int minuti, int secondi) throws Exception {
		if (ora >= 0 && minuti >= 0 && minuti <= 60 && secondi >= 0 && secondi <= 60) {
			this.ora = LocalTime.of(ora, minuti, secondi);
		} else {
			throw new Exception("valori inseriti per l'ora non corretti ");

		}
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) throws Exception {
		if (prezzo.compareTo(BigDecimal.valueOf(0.0)) > 0) {
			this.prezzo = prezzo;
		}

	}
	// -----------------------------------------------

	// ---------------FUNZIONI------------------
	public void ritornoOraEPrezzo() {
		this.prezzoFormattato = this.prezzo + "€";
		this.oraFormattata = this.ora.toString();
	}

	public String getPrezzoFormattato() {
		return prezzoFormattato;
	}

	public String getOraFormattata() {
		return oraFormattata;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getData() + this.getOraFormattata() + " - " + this.getTitolo() + " - " + this.getPrezzoFormattato();
	}
	// -----------------------------------------------

}
