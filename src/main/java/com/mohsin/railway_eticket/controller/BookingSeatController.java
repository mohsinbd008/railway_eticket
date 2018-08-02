/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.mohsin.railway_eticket.domain.BookingSeat;
import com.mohsin.railway_eticket.domain.RouteStation;
import com.mohsin.railway_eticket.service.IBookingSeatService;
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
@RequestMapping("/bseat")
public class BookingSeatController {
      @Autowired
    private IBookingSeatService IBookingSeatService;
       @RequestMapping("/home")
    public String home() {
        return "bseat";
    }
       @RequestMapping(value = "/bseatlist", method = RequestMethod.GET)
        public ResponseEntity<List<BookingSeat>> getAllBookingSeat() {
        List<BookingSeat> list = IBookingSeatService.getAllBookingSeat();
        return new ResponseEntity<List<BookingSeat>>(list, HttpStatus.OK);
    
}
     @RequestMapping(value = "/bseatlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookingSeat> getBookingSeatById(@PathVariable("id") Integer id) {
        BookingSeat rstation = IBookingSeatService.getBookingSeatById(id);
        return new ResponseEntity<BookingSeat>(rstation, HttpStatus.OK);

    }
       @RequestMapping(value = "/bseatlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addBookingSeat(@RequestBody BookingSeat obj, UriComponentsBuilder builder) {
        boolean flag = IBookingSeatService.addBookingSeat(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/bseatlist/{id}").buildAndExpand(obj.getBoSeatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
        @RequestMapping(value = "/bseatlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookingSeat> updateBookingSeat(@RequestBody BookingSeat bseat) {
        IBookingSeatService.updateBookingSeat(bseat);
        return new ResponseEntity<BookingSeat>(bseat, HttpStatus.OK);
    }
      @RequestMapping(value = "/bseatlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBookingSeat(@PathVariable("id") Integer id) {
        IBookingSeatService.deleteBookingSeat(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
