package com.knowledge.admin.repository.impl;

import com.knowledge.admin.constants.KnowledgePackageDatabaseQuery;
import com.knowledge.admin.entity.KnowledgePackageSet;
import com.knowledge.admin.mapper.KnowledgePackageSetRowMapper;
import com.knowledge.admin.repository.KpacSetDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class KpacSetDaoImpl implements KpacSetDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public KpacSetDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<KnowledgePackageSet> getAllKpacSet() {
		return jdbcTemplate.query(KnowledgePackageDatabaseQuery.SELECT_KPAC_SET_QUERY
				, (rs, row) -> new KnowledgePackageSetRowMapper().mapRow(rs,row));
	}

	@Override
	public List<KnowledgePackageSet> getKpacSet(int id) {
		return jdbcTemplate.query(KnowledgePackageDatabaseQuery.SELECT_KPAC_SET_BY_ID_QUERY
				, preparedStatement -> preparedStatement.setInt(1, id)
				, (rs, row) -> new KnowledgePackageSetRowMapper().mapRow(rs,row));
	}

	@Override
	public int[] saveKpacSet(KnowledgePackageSet knowledgePackageSet) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(KnowledgePackageDatabaseQuery.INSERT_KPAC_SET_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, knowledgePackageSet.getTitle());
			return ps;
		}, keyHolder);
		int generatedPrimaryKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
		final List<Integer> kpacIds = knowledgePackageSet.getKpacIds();
		if (kpacIds != null && !kpacIds.isEmpty()) {
			return jdbcTemplate.batchUpdate(KnowledgePackageDatabaseQuery.INSERT_KPS_KP_QUERY, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, knowledgePackageSet.getTitle());
					ps.setInt(1, generatedPrimaryKey);
					ps.setInt(2, kpacIds.get(i));
				}
				@Override
				public int getBatchSize() {
					return kpacIds.size();
				}
			});
		}
		return new int[0];
	}

	@Override
	public int deleteKpacSet(final int id) {
		return jdbcTemplate.update(KnowledgePackageDatabaseQuery.DELETE_KPAC_SET_QUERY, id);
	}

}
