package com.ppleflow.challenge.hrplatform.repository;


import com.ppleflow.challenge.hrplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
