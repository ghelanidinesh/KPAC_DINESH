package com.knowledge.admin.services.impl;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.dto.KnowledgePackageDTO;
import com.knowledge.admin.entity.KnowledgePackage;
import com.knowledge.admin.repository.KpacDao;
import com.knowledge.admin.services.KpacService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class KpacServiceImpl implements KpacService {

	private final KpacDao kpacDao;

	@Autowired
	public KpacServiceImpl(KpacDao kpacDao) {
		this.kpacDao = kpacDao;
	}

	@Override
	public List<KnowledgePackageDTO> getAllKpacs() {
		final List<KnowledgePackage> knowledgePackages = kpacDao.getAllKpacs();
		return getKnowledgePackageDTOS(knowledgePackages);
	}

	@Override
	public List<KnowledgePackageDTO> getKpacsBySetId(final int setId) {
		final List<KnowledgePackage> knowledgePackages = kpacDao.getKpacs(setId);
		return getKnowledgePackageDTOS(knowledgePackages);
	}

	@Override
	public void deleteKpac(final int id) {
		kpacDao.deleteKpac(id);
	}

	@Override
	public void saveKpac(final KnowledgePackage knowledgePackage) {
		if (null != knowledgePackage) {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(KnowledgePackageConstant.DATE_FORMAT);
			String creationDate = simpleDateFormat.format(date);
			knowledgePackage.setCreationDate(creationDate);
			kpacDao.saveKpac(knowledgePackage);
		}
	}
	private List<KnowledgePackageDTO> getKnowledgePackageDTOS(List<KnowledgePackage> knowledgePackages) {
		if(null == knowledgePackages ||  knowledgePackages.isEmpty()){
			return Collections.emptyList();
		}
		return knowledgePackages
				.stream().map(
						knowledgePackage -> new KnowledgePackageDTO(
								knowledgePackage.getId(), knowledgePackage.getTitle()
								, knowledgePackage.getDescription(), knowledgePackage.getCreationDate()))
				.collect(Collectors.toList());
	}
}
