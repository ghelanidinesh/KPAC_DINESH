package com.knowledge.admin.mapper;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.entity.KnowledgePackage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KnowledgePackageRowMapper implements RowMapper<KnowledgePackage> {
    @Override
    public KnowledgePackage mapRow(final ResultSet rs, int rowNum) throws SQLException {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setId(rs.getInt(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.COLUMN_ID));
        knowledgePackage.setTitle(rs.getString(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.TITLE));
        knowledgePackage.setDescription(rs.getString(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.DESCRIPTION));
        knowledgePackage.setCreationDate(rs.getString(KnowledgePackageConstant.KnowledgePackageDatabaseConstants.CREATED_DATE));
        return knowledgePackage;
    }
}
