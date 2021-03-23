package com.cg.MVCThymeDB.MVCDatabase.services;

import com.cg.MVCThymeDB.MVCDatabase.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.MVCThymeDB.MVCDatabase.pojo.User;
import java.util.List;

// Service annotation marks class as a service. 
@Service
public class UserServices {

    // Dependency injection of the dao
    @Autowired
    UserDAO userDAO;

    // Add new user
    public User addUser(User user){
        
        return userDAO.save(user);

    }

    // TODO: Update user

    // TODO: Remove user by id

    // Get user
    public User retrieve(int _id){

        if(userDAO.existsById(_id))
            return userDAO.findById(_id).get();
        
        // Should be corrected in the future. This returns null if the user foesn't exist.
        return null;

    }

    // Get all users
    public List<User> retrieveAllUsers(){
        
        return userDAO.findAll();

    }
}
