package com.yacine.DocumentRules.Repo;

import com.yacine.DocumentRules.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByUserName(String name);

}
