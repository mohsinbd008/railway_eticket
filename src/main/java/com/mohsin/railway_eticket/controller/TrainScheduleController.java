package com.mohsin.railway_eticket.controller;
import com.mohsin.railway_eticket.domain.TrainSchedule;
import com.mohsin.railway_eticket.service.ITrainScheduleService;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author R-34
 */
@Controller
@RequestMapping("/schedule")
public class TrainScheduleController {

    @Autowired
    private ITrainScheduleService iTrainScheduleService;

    @RequestMapping("/home")
    public String home() {
        return "scheduleinfo";
    }

    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    public ResponseEntity<List<TrainSchedule>> getAllObject() {
        List<TrainSchedule> list = iTrainScheduleService.getAllObject();
        return new ResponseEntity<List<TrainSchedule>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrainSchedule> getObjectById(@PathVariable("id") Integer id) {
        TrainSchedule schedule = iTrainScheduleService.getObjectById(id);
        return new ResponseEntity<TrainSchedule>(schedule, HttpStatus.OK);

    }

    @RequestMapping(value = "/schedulelist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody TrainSchedule obj, UriComponentsBuilder builder) {
        boolean flag = iTrainScheduleService.addObject(obj);
        //  System.out.println("CoachInfo:"+obj.toString());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/schedulelist/{id}").buildAndExpand(obj.getScheduleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TrainSchedule> updateObject(@RequestBody TrainSchedule obj) {
        iTrainScheduleService.updateObject(obj);
        return new ResponseEntity<TrainSchedule>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iTrainScheduleService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
