package com.knowledge.admin.services;
import com.knowledge.admin.dto.KnowledgePackageSetDTO;
import com.knowledge.admin.entity.KnowledgePackageSet;

import java.util.List;

public interface KpacSetService {
	List<KnowledgePackageSetDTO> getAllKpacSet();

	void saveKpacSet(final KnowledgePackageSet knowledgePackageSet);

	void deleteKpacSet(int id);

}
