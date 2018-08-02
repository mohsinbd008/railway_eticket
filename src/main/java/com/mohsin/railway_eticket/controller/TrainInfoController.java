/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mohsin.railway_eticket.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohsin.railway_eticket.domain.TrainInfo;
import com.mohsin.railway_eticket.service.ITrainInfoService;
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
 * @author Faculty
 */
@Controller
@RequestMapping("/train")
public class TrainInfoController {

    @Autowired
    private ITrainInfoService iTrainInfoService;

    @RequestMapping("/home")
    public String home() {
        return "traininfo";
    }
    @RequestMapping(value = "/trainlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<TrainInfo>> getAllTrain() {
      //  List<TrainInfo> list=iTrainInfoService.
        List<TrainInfo> list = iTrainInfoService.getAllTrainInfo();
        return new ResponseEntity<List<TrainInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrainInfo> getTrainById(@PathVariable("id") Integer id) {
        TrainInfo trainInfo=iTrainInfoService.getTrainById(id);
      //  TrainInfo trainInfo = iTrainInfoService.getTrainById(id);
        return new ResponseEntity<TrainInfo>(trainInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addPTrain(@RequestBody TrainInfo trainInfo, UriComponentsBuilder builder) {
        boolean flag = iTrainInfoService.addTrain(trainInfo);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/trainlist/{id}").buildAndExpand(trainInfo.getTrainId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/trainlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TrainInfo> updateTrain(@RequestBody TrainInfo trainInfo) {
        iTrainInfoService.updateTrain(trainInfo);
        return new ResponseEntity<TrainInfo>(trainInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTrain(@PathVariable("id") Integer id) {
        iTrainInfoService.deleteTrain(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
