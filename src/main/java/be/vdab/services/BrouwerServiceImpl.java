package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerMetDezeNaamBestaatAlException;

@Service
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	@Override
	public void create(Brouwer brouwer) {
		if (brouwerDAO.findByNaam(brouwer.getNaam()) != null) {
			throw new BrouwerMetDezeNaamBestaatAlException();
		}
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
	public Iterable<Brouwer> opAlfabet(String letter) {
		return brouwerDAO.findByNaam(letter);
	}

	@Override
	public long findAantalBrouwers() {
		return brouwerDAO.findAantalBrouwers();
	}
}
