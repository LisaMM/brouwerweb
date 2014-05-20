package be.vdab.dao;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO {
	void create(Brouwer brouwer);
	Iterable<Brouwer> findAll();
	Iterable<Brouwer> findByNaam(String beginNaam);
	Iterable<Brouwer> opAlfabet(char letter);
	long findAantalBrouwers();
}
