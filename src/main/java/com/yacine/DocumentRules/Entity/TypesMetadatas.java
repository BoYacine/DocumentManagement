package com.yacine.DocumentRules.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yacine.DocumentRules.Entity.MetaData;
import com.yacine.DocumentRules.Entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TypesMetadatas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Type type;
    @ManyToOne
    MetaData metaData;
    @OneToMany(mappedBy = "typesMetadatas",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<MetaDataValue> metaDataValues=new ArrayList<>();
}
