package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepo extends JpaRepository<Folder,Long> {
    Folder findByUserIdAndName(Long id,String name);
    List<Folder> findByPointer(Long id);
    List<Folder> findByUserId(Long id);
}
