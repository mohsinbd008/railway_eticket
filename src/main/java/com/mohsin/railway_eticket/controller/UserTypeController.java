/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohsin.railway_eticket.domain.UserType;
import com.mohsin.railway_eticket.service.IUserTypeService;
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
 * @author R-34
 */
@Controller
@RequestMapping("/utype")
public class UserTypeController {

    @Autowired
    private IUserTypeService iUserTypeService;

    @RequestMapping("/home")
    public String home() {
        return "utype";
    }

    @RequestMapping(value = "/utypelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<UserType>> getAllUserType() {
        //  List<UserType> list=iUserTypeService.
        List<UserType> list = iUserTypeService.getAllUserType();
        return new ResponseEntity<List<UserType>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/utypelist/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserType> getUserTypeById(@PathVariable("id") Integer id) {
        UserType utypeInfo = iUserTypeService.getUserTypeById(id);
        //  UserType utypeInfo = iUserTypeService.getUserTypeById(id);
        return new ResponseEntity<UserType>(utypeInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/utypelist", method = RequestMethod.POST)
    public ResponseEntity<Void> addUserType(@RequestBody UserType utypeInfo, UriComponentsBuilder builder) {
        boolean flag = iUserTypeService.addUserType(utypeInfo);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/utypelist/{id}").buildAndExpand(utypeInfo.getUTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/utypelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserType> updateUserType(@RequestBody UserType utypeInfo) {
        iUserTypeService.updateUserType(utypeInfo);
        return new ResponseEntity<UserType>(utypeInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/utypelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserType(@PathVariable("id") Integer id) {
        iUserTypeService.deleteUserType(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
