package com.knowledge.admin.mapper;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.entity.KnowledgePackageSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KnowledgePackageSetRowMapper implements RowMapper<com.knowledge.admin.entity.KnowledgePackageSet> {
    @Override
    public KnowledgePackageSet mapRow(ResultSet rs, int rowNum) throws SQLException {
        final KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setId(rs.getInt(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.COLUMN_ID));
        knowledgePackageSet.setTitle(rs.getString(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.TITLE));
        return knowledgePackageSet;
    }
}
