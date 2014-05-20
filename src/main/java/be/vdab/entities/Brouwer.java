package be.vdab.entities;

import java.io.Serializable;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long brouwerNr;
	private String naam;
	@NumberFormat(style = Style.CURRENCY)
	private Integer omzet;
	private Adres adres;
	
	public Brouwer(String naam, Integer omzet, Adres adres) {
		setNaam(naam);
		setAdres(adres);
		setOmzet(omzet);
	}
	
	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		setBrouwerNr(brouwerNr);
		setNaam(naam);
		setAdres(adres);
		setOmzet(omzet);
	}
	
	public long getBrouwerNr() {
		return brouwerNr;
	}
	
	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public Integer getOmzet() {
		return omzet;
	}
	
	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}
	
	public Adres getAdres() {
		return adres;
	}
	
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	@Override
	public String toString() {
		return naam + ":" + brouwerNr;
	}

}
