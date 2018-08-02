/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.ISeatBookingDAO;
import com.mohsin.railway_eticket.dao.ITrainScheduleDAO;
import com.mohsin.railway_eticket.domain.TrainSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service

public class TrainScheduleService implements ITrainScheduleService {

    @Autowired
    private ITrainScheduleDAO iTrainScheduleDAO;

    @Override
    public List<TrainSchedule> getAllObject() {
        return iTrainScheduleDAO.getAllObject();
    }

    @Override
    public TrainSchedule getObjectById(int id) {
        TrainSchedule u = iTrainScheduleDAO.getObjectById(id);
        return u;
    }

    @Override
    public synchronized boolean addObject(TrainSchedule obj) {
        if (iTrainScheduleDAO.ObjectExists(obj.getDeparTime())) {
            return false;
        } else {
            iTrainScheduleDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(TrainSchedule obj) {
        iTrainScheduleDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iTrainScheduleDAO.deleteObject(id);
    }

}
