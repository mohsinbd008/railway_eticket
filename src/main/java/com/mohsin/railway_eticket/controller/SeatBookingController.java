/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.mohsin.railway_eticket.domain.BookingSeat;
import com.mohsin.railway_eticket.service.ISeatBookingService;
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
@RequestMapping("/seatbooking")
public class SeatBookingController {

    @Autowired
    private ISeatBookingService iSeatBookingService;

    @RequestMapping("/home")
    public String home() {
        return "seatbooking";
    }

    @RequestMapping(value = "/seatbookinglist", method = RequestMethod.GET)
    public ResponseEntity<List<BookingSeat>> getAllObject() {
        List<BookingSeat> list = iSeatBookingService.getAllObject();
        return new ResponseEntity<List<BookingSeat>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/seatbookinglist/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookingSeat> getObjectById(@PathVariable("id") Integer id) {
        BookingSeat user = iSeatBookingService.getObjectById(id);
        return new ResponseEntity<BookingSeat>(user, HttpStatus.OK);

    }

    @RequestMapping(value = "/seatbookinglist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BookingSeat obj, UriComponentsBuilder builder) {
        boolean flag = iSeatBookingService.addObject(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/seatbookinglist/{id}").buildAndExpand(obj.getBoSeatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/seatbookinglist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookingSeat> updateObject(@RequestBody BookingSeat obj) {
        iSeatBookingService.updateObject(obj);
        return new ResponseEntity<BookingSeat>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/seatbookinglist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iSeatBookingService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
