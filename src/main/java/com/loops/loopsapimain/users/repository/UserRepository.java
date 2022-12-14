package com.loops.loopsapimain.users.repository;

import com.loops.loopsapimain.users.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findUserByUserEmail(String userEmail);



    User findOneByUserEmailIgnoreCaseAndUserPassword(String userEmail, String userPassword);
}
