package com.knowledge.admin.repository;


import com.knowledge.admin.entity.KnowledgePackage;

import java.util.List;

public interface KpacDao {

	List<KnowledgePackage> getAllKpacs();

	List<KnowledgePackage> getKpacs(int setId);

	int deleteKpac(int id);

	int saveKpac(KnowledgePackage knowledgePackage);

}
