package com.bluntsoftware.bizvest.shared.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Registrar {
    @Id
    String id;
    String tenantId;
    String company;
    String type;
    boolean active = false;
}
