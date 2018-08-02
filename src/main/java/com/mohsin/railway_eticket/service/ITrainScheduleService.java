/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.domain.TrainSchedule;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface ITrainScheduleService {
         List<TrainSchedule> getAllObject();

    TrainSchedule getObjectById(int id);

    boolean addObject(TrainSchedule obj);

    void updateObject(TrainSchedule obj);

    void deleteObject(int id);
}
