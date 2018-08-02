/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.mohsin.railway_eticket.domain.RouteStation;
import com.mohsin.railway_eticket.service.IRouteStationService;
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
@RequestMapping("/station")
public class RouteStationController {
       @Autowired
    private IRouteStationService iRouteStationService;
       @RequestMapping("/home")
    public String home() {
        return "routestation";
    }
       @RequestMapping(value = "/stationlist", method = RequestMethod.GET)
    public ResponseEntity<List<RouteStation>> getAllRouteStation() {
        List<RouteStation> list = iRouteStationService.getAllRouteStation();
        return new ResponseEntity<List<RouteStation>>(list, HttpStatus.OK);
    
}
     @RequestMapping(value = "/stationlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<RouteStation> getRouteStationById(@PathVariable("id") Integer id) {
        RouteStation rstation = iRouteStationService.getRouteStationById(id);
        return new ResponseEntity<RouteStation>(rstation, HttpStatus.OK);

    }
       @RequestMapping(value = "/stationlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addRouteStation(@RequestBody RouteStation obj, UriComponentsBuilder builder) {
        boolean flag = iRouteStationService.addRouteStation(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/stationlist/{id}").buildAndExpand(obj.getStationId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
        @RequestMapping(value = "/stationlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RouteStation> updateRouteStation(@RequestBody RouteStation routeStation) {
        iRouteStationService.updateRouteStation(routeStation);
        return new ResponseEntity<RouteStation>(routeStation, HttpStatus.OK);
    }
      @RequestMapping(value = "/stationlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRouteStation(@PathVariable("id") Integer id) {
        iRouteStationService.deleteRouteStation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
