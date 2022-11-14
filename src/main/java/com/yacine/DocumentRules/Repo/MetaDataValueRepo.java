package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.MetaDataValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataValueRepo extends JpaRepository<MetaDataValue,Long> {
}
