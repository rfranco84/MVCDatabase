package com.cg.MVCThymeDB.MVCDatabase.controllers;

// Needed imports to use RestController, Autowired, ModelAndView, etc. 

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.MVCThymeDB.MVCDatabase.pojo.*;
import com.cg.MVCThymeDB.MVCDatabase.services.UserServices;


// Marks class as Controller
@RestController
public class UserController {

    // Service dependency injection
    @Autowired
    UserServices service;

    // Initial view is the index.html page. In it, there is a link pointing to the following mapping "/register"
    // Returns ModelAndView object, initialized with the view "/registration_form", which links to registration_form.html
    @GetMapping("/register")
    public ModelAndView showForm(){

        // Object that will be worked with in the registration form
        User user = new User();

        // ModelAndView object pointing to registration_form.html
        ModelAndView mav = new ModelAndView("/registration_form");

        // user is added as an object to the ModelAndView object. This will enable the mav to work with the user object
        mav.addObject("user", user);

        return mav;

    }

    // Links from registration_form, specifying POST method, indicating that this method will be used for input.
    // Input is the user. ModelAttribute annotation must be used to properly link the user object from the html file
    // to this method. ModelAndView object is returned. This object points at a view called "/success", referring to
    // success.html
    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("user") User user){

        // mav referring to success.html
        ModelAndView mav = new ModelAndView("/success");

        // service will add the user object to the database
        service.addUser(user);

        return mav;

    }

    // TODO: Update User

    // TODO: Delete User

    // TODO: Get User by ID

    // Gets all users. Links from success.html (via "/list_users") when the client indicates they don't want to register another user. 
    // Returns ModelAndView object referring to "/list" which points to list.html.
    @GetMapping("/list_users")
    public ModelAndView showAllUsers(){

        ModelAndView mav = new ModelAndView("/list");

        // To work with the list of users, the list must be added to the mav through the service object.
        mav.addObject("user_list", service.retrieveAllUsers());

        return mav;

    }

    /** For Testing Only! **/
    /***********************************
    @PostMapping("/user")
    public String postTest(@RequestBody User user){

        service.addUser(user);

        return "success";

    }

    @GetMapping("/user/{id}")
    public User obtainById(@PathVariable("id")int id){
        
        return service.retrieve(id);
        
    }
    ************************************
    */

    // To test obtain by ID returned in JSON format
    // PathVariable annotation must be used to enable to use the id number indicated in the path.
    @GetMapping("/user/{id}")
    public User obtainById(@PathVariable("id")int id){
        
        // Gets user by id. 
        return service.retrieve(id);
        
    }
    
}
