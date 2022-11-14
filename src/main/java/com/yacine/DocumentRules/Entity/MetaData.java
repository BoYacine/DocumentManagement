package com.yacine.DocumentRules.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "metadata")
@Data @AllArgsConstructor @NoArgsConstructor
public class MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "MetaName")
    private String name;
    private String typeData;
    @OneToMany(mappedBy = "metaData",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TypesMetadatas> typesMetadatas=new ArrayList<>();


}
