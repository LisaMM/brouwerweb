package be.vdab.services;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	void create(Brouwer brouwer);
	Iterable<Brouwer> findAll();
	Iterable<Brouwer> findByNaam(String beginNaam);
	Iterable<Brouwer> opAlfabet(char letter);
}
