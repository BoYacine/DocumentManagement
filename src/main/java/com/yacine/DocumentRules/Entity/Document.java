package com.yacine.DocumentRules.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Document {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    Type type;
    @OneToMany(mappedBy = "document")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<MetaDataValue> metaDataValues;


}
