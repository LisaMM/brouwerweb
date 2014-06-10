package be.vdab.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerDAOImpl implements BrouwerDAO {
	private final JdbcTemplate jdbcTemplate;
	private final BrouwerRowMapper brouwerRowMapper = new BrouwerRowMapper();
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	private static final String SQL_FIND_ALL =
			"select brouwerNr, naam, omzet, straat, huisNr, postcode, gemeente" +
			" from brouwers order by naam";
	private static final String SQL_FIND_BY_NAAM =
			"select brouwerNr, naam, omzet, straat, huisNr, postcode, gemeente "
			+ "from brouwers where naam like ? order by naam";
	private static final String SQL_FIND_AANTAL_BROUWERS =
			"select count(*) from brouwers";
	
	@Autowired
	public BrouwerDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("brouwerNr");
	}

	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisNr", brouwer.getAdres().getHuisNr());
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		Number brouwerNr = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
		brouwer.setBrouwerNr(brouwerNr.longValue());
	}

	@Override
	public Iterable<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, brouwerRowMapper);
	}

	@Override
	public Iterable<Brouwer> findByNaam(String beginNaam) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, brouwerRowMapper, beginNaam + "%");
	}

	@Override
	public long findAantalBrouwers() {
		return jdbcTemplate.queryForObject(SQL_FIND_AANTAL_BROUWERS, Long.class);
	}
	
	private static class BrouwerRowMapper implements RowMapper<Brouwer> {
		@Override
		public Brouwer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Brouwer (resultSet.getLong("brouwerNr"),
					resultSet.getString("naam"),
					resultSet.getInt("omzet"),
					new Adres(resultSet.getString("straat"),
						resultSet.getString("huisNr"),
						resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
		}
	}
}
