package com.yacine.DocumentRules.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class MetaDataValue {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String value;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    TypesMetadatas typesMetadatas;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Document document;
}
