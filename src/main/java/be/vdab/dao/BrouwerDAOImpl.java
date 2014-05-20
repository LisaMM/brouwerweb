package be.vdab.dao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerDAOImpl implements BrouwerDAO {
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	
	public BrouwerDAOImpl() {
		brouwers.put(1L, new Brouwer(1L, "Karelmans", 1000, 
			new Adres("Keizerslaan", "11", 1000, "Brussel")));
		brouwers.put(2L, new Brouwer(2L, "Krieke", 5050, 
			new Adres("Gasthuisstraat", "31", 1000, "Brussel")));
		brouwers.put(3L, new Brouwer(3L, "Hoge Maan", 3000, 
			new Adres("Koestraat", "44", 9700, "Oudenaarde")));
		brouwers.put(4L, new Brouwer(4L, "Achouffe", 8832,
			new Adres("Route du Village", "32", 6666, "Achouffe-Wibrin")));
		brouwers.put(5L, new Brouwer(5L, "Alken", 1234,
			new Adres("StationStraat", "2", 3570, "Alken")));
		brouwers.put(8L, new Brouwer(8L, "Bavik", 55,
			new Adres("Rijksweg", "33", 8531, "Bavikhove")));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwer.setBrouwerNr(Collections.max(brouwers.keySet()) + 1);
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	}

	@Override
	public Iterable<Brouwer> findAll() {
		return brouwers.values();
	}

	@Override
	public Iterable<Brouwer> findByNaam(String beginNaam) {
		beginNaam = beginNaam.toUpperCase();
		List<Brouwer> brouwersMetNaam = new ArrayList<>();
		for (Brouwer brouwer : brouwers.values()) {
			if (brouwer.getNaam().toUpperCase().startsWith(beginNaam)) {
				brouwersMetNaam.add(brouwer);
			}
		}
		return brouwersMetNaam;
	}

	@Override
	public Iterable<Brouwer> opAlfabet(char letter) {
		List<Brouwer> brouwersMetLetter = new ArrayList<>();
		for (Brouwer brouwer : brouwers.values()) {
			if (brouwer.getNaam().charAt(0) == letter) {
				brouwersMetLetter.add(brouwer);
			}
		}
		return brouwersMetLetter;
	}

	@Override
	public long findAantalBrouwers() {
		return brouwers.size();
	}
}
