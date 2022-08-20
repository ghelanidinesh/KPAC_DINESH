package com.knowledge.admin.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KnowledgePackageDTO {
    private int id;
    private String title;
    private String description;
    private String creationDate;
}
