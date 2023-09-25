package org.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Spettacolo extends Evento{
	
public Spettacolo(String titolo, LocalDate data, int numeroPostiTotali,BigDecimal prezzo) throws Exception {
		super(titolo, data, numeroPostiTotali);
this.setPrezzo(prezzo);	}

public BigDecimal getPrezzo() {
	return prezzo;
}

public void setPrezzo(BigDecimal prezzo) {
	this.prezzo = prezzo;
}

private BigDecimal prezzo;
}
