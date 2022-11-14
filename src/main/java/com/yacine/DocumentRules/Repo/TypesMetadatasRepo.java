package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.TypesMetadatas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesMetadatasRepo extends JpaRepository<TypesMetadatas,Long> {
}
