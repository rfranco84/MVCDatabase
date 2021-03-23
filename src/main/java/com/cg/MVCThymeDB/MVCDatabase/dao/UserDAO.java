package com.cg.MVCThymeDB.MVCDatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.MVCThymeDB.MVCDatabase.pojo.User;

// Repository annotation tells Spring Boot that this interface will be communicating with the database. 
// JpaRepository must be extended to be able to use hibernate abstraction
@Repository
public interface UserDAO extends JpaRepository<User,Integer>{
    
}
