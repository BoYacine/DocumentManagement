package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepo extends JpaRepository<MetaData,Long> {
    MetaData findByname(String name);
}
