package com.yacine.DocumentRules;

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
    @ManyToMany(mappedBy = "types",fetch = FetchType.EAGER)
    private List<MetaData> metaData=new ArrayList<>();
}
