package com.fairprice.fairprice.auth.repo;

import com.fairprice.fairprice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
