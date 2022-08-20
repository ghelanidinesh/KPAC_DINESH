package com.knowledge.admin.repository.impl;

import com.knowledge.admin.constants.KnowledgePackageDatabaseQuery;
import com.knowledge.admin.entity.KnowledgePackage;
import com.knowledge.admin.mapper.KnowledgePackageRowMapper;
import com.knowledge.admin.repository.KpacDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class KpacDaoImpl implements KpacDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public KpacDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<KnowledgePackage> getAllKpacs() {
		return jdbcTemplate.query(KnowledgePackageDatabaseQuery.SELECT_KPAC_QUERY
				,(resultSet, row) -> new KnowledgePackageRowMapper().mapRow(resultSet, row));
	}

	@Override
	public List<KnowledgePackage> getKpacs(int setId) {
		return jdbcTemplate.query(KnowledgePackageDatabaseQuery.SELECT_KPAC_FROM_SETID_QUERY,  new KnowledgePackageRowMapper(), setId);
	}

	@Override
	public int deleteKpac(int id) {
		return jdbcTemplate.update(KnowledgePackageDatabaseQuery.DELETE_KPAC_QUERY, id);
	}

	@Override
	public int saveKpac(KnowledgePackage knowledgePackage) {
		return jdbcTemplate.update(KnowledgePackageDatabaseQuery.INSERT_KPAC_QUERY, knowledgePackage.getTitle(), knowledgePackage.getDescription(),
				knowledgePackage.getCreationDate());
	}
}
