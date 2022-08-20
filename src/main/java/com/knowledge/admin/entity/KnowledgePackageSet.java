package com.knowledge.admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class KnowledgePackageSet {
    private int id;
    private String title;
    private List<Integer> kpacIds;

}
