/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohsin.railway_eticket.domain.Route;
import com.mohsin.railway_eticket.service.IRouteInfoService;
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
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private IRouteInfoService iRouteInfoService;

    @RequestMapping("/home")
    public String home() {
        return "routeinfo";
    }

    @RequestMapping(value = "/routelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Route>> getAllRoute() {
        //  List<TrainInfo> list=iTrainInfoService.
        List<Route> list = iRouteInfoService.getAllRoute();
        return new ResponseEntity<List<Route>>(list, HttpStatus.OK);

    }

    @RequestMapping(value = "/routelist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getRouteById(@PathVariable("id") Integer id) {
        Route routeInfo = iRouteInfoService.getRouteById(id);
        //  TrainInfo trainInfo = iTrainInfoService.getTrainById(id);
        return new ResponseEntity<Route>(routeInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/routelist", method = RequestMethod.POST)
    public ResponseEntity<Void> addRoute(@RequestBody Route routeInfo, UriComponentsBuilder builder) {
        boolean flag = iRouteInfoService.addRoute(routeInfo);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/routelist/{id}").buildAndExpand(routeInfo.getRouteId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/routelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Route> updateRoute(@RequestBody Route routeInfo) {
        iRouteInfoService.updateRoute(routeInfo);
        return new ResponseEntity<Route>(routeInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/routelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRoute(@PathVariable("id") Integer id) {
        iRouteInfoService.deleteRoute(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
