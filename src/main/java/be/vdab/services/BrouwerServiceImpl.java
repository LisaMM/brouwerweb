package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true)
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}

	@Override
	public Iterable<Brouwer> findAll() {
		return brouwerDAO.findAll(new Sort("naam"));
	}

	@Override
	public Iterable<Brouwer> findByNaam(String beginNaam) {
		return brouwerDAO.findByNaamOrderByNaamAsc(beginNaam);
	}
}
