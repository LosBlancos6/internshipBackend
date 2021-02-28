package com.intens.proj.repository;

import com.intens.proj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);

    List<User> findByName(String name);

}
