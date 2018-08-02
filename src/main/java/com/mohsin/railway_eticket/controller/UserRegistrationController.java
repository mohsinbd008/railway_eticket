/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.mohsin.railway_eticket.domain.User;
import com.mohsin.railway_eticket.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Mohsin
 */
@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/home")
    public String home() {
        return "register";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = iUserService.getAllUser();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = iUserService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @RequestMapping(value = "/userlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User obj, UriComponentsBuilder builder) {
        boolean flag = iUserService.addUser(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/userlist/{id}").buildAndExpand(obj.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
//    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
//    public ResponseEntity<Void> userLogin(@RequestBody User obj, UriComponentsBuilder builder) {
//        boolean flag = iUserService.userLogin(obj);
//        //  System.out.println("CoachInfo:"+obj.toString());
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/userlogin/{id}").buildAndExpand(obj.getUserId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User userInfo) {
        iUserService.updateUser(userInfo);
        return new ResponseEntity<User>(userInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iUserService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
