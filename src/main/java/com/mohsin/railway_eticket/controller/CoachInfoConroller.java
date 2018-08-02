/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import com.mohsin.railway_eticket.domain.CoachInfo;
import com.mohsin.railway_eticket.service.ICoachInfoService;
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
@RequestMapping("/coach")
public class CoachInfoConroller {

    @Autowired
    private ICoachInfoService iCoachInfoService;

    @RequestMapping("/home")
    public String home() {
        return "coachinfo";
    }

    @RequestMapping(value = "/coachlist", method = RequestMethod.GET)
    public ResponseEntity<List<CoachInfo>> getAllCoach() {
        List<CoachInfo> list = iCoachInfoService.getAllCoach();
        return new ResponseEntity<List<CoachInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/coachlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<CoachInfo> getCoachById(@PathVariable("id") Integer id) {
        CoachInfo tcoach = iCoachInfoService.getCoachById(id);
        return new ResponseEntity<CoachInfo>(tcoach, HttpStatus.OK);

    }
      @RequestMapping(value = "/coachlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addCoach(@RequestBody CoachInfo obj, UriComponentsBuilder builder) {
        boolean flag = iCoachInfoService.addCoach(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/coachlist/{id}").buildAndExpand(obj.getCoachId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/coachlist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addCoach(@RequestBody CoachInfo tcoach, UriComponentsBuilder builder) {
//        boolean flag = iCoachInfoService.addCoach(tcoach);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/coachlist/{id}").buildAndExpand(tcoach.getCoachId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/coachlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CoachInfo> updateCoach(@RequestBody CoachInfo coachInfo) {
        iCoachInfoService.updateCoach(coachInfo);
        return new ResponseEntity<CoachInfo>(coachInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/coachlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCoach(@PathVariable("id") Integer id) {
        iCoachInfoService.deleteCoach(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
