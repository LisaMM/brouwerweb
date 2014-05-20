package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwerDAO.create(brouwer);
	}

	@Override
	public Iterable<Brouwer> findAll() {
		return brouwerDAO.findAll();
	}

	@Override
	public Iterable<Brouwer> findByNaam(String beginNaam) {
		return brouwerDAO.findByNaam(beginNaam);
	}

	@Override
	public Iterable<Brouwer> opAlfabet(char letter) {
		return brouwerDAO.opAlfabet(letter);
	}

	@Override
	public long findAantalBrouwers() {
		return brouwerDAO.findAantalBrouwers();
	}
}
