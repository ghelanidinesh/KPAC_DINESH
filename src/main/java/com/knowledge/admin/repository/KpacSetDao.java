package com.knowledge.admin.repository;

import com.knowledge.admin.entity.KnowledgePackageSet;

import java.util.List;

public interface KpacSetDao {

    List<KnowledgePackageSet> getAllKpacSet();

    List<KnowledgePackageSet> getKpacSet(int id);

    int[] saveKpacSet(KnowledgePackageSet knowledgePackageSet);

    int deleteKpacSet(int id);

}
