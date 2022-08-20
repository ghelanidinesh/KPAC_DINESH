package com.knowledge.admin.services;
import com.knowledge.admin.dto.KnowledgePackageDTO;
import com.knowledge.admin.entity.KnowledgePackage;

import java.util.List;

public interface KpacService {

	List<KnowledgePackageDTO> getAllKpacs();

	List<KnowledgePackageDTO> getKpacsBySetId(final int setId);

	void deleteKpac(final int id);

	void saveKpac(final KnowledgePackage knowledgePackage);

}
