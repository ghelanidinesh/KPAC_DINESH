package com.knowledge.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KnowledgePackageSetDTO {
    private int id;
    private String title;
    private List<Integer> knowledgePackageIds;
}
