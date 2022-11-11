package com.yacine.DocumentRules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
