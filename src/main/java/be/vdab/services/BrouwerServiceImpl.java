package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerMetDezeNaamBestaatAlException;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	@Override
	@Transactional(readOnly = false)
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
}
