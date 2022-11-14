package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<Document,Long> {
}
