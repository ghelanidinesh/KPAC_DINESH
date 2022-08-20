package com.knowledge.admin.services.impl;

import com.knowledge.admin.dto.KnowledgePackageSetDTO;
import com.knowledge.admin.entity.KnowledgePackageSet;
import com.knowledge.admin.repository.KpacSetDao;
import com.knowledge.admin.services.KpacSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class KpacSetServiceImpl implements KpacSetService {
	private final KpacSetDao kpacSetDao;

	@Autowired
	public KpacSetServiceImpl(KpacSetDao kpacSetDao) {
		this.kpacSetDao = kpacSetDao;
	}

	@Override
	public List<KnowledgePackageSetDTO> getAllKpacSet() {
		final List<KnowledgePackageSet> knowledgePackageSets = kpacSetDao.getAllKpacSet();
		if(knowledgePackageSets.isEmpty()){
			return Collections.emptyList();
		}
		return knowledgePackageSets.stream().map(
				knowledgePackageSet -> new KnowledgePackageSetDTO(
						knowledgePackageSet.getId(),
						knowledgePackageSet.getTitle(),
						null))
				.collect(Collectors.toList());
	}

	@Override
	public void saveKpacSet(final KnowledgePackageSet knowledgePackageSet) {
		kpacSetDao.saveKpacSet(knowledgePackageSet);
	}

	@Override
	public void deleteKpacSet(final int id) {
		kpacSetDao.deleteKpacSet(id);
	}

}
