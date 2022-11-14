package com.yacine.DocumentRules.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
@Data @AllArgsConstructor @NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "TypeName")
    private String name;
    @OneToMany(mappedBy = "type",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TypesMetadatas> typesMetadatas=new ArrayList<>();
    @OneToMany(mappedBy = "type")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  List<Document> documents;
}
