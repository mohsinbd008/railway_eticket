/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.ITrainInfoDAO;
import com.mohsin.railway_eticket.domain.TrainInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class TrainInfoService implements ITrainInfoService {

    @Autowired
    private ITrainInfoDAO iTrainInfoDAO;

    @Override
    public List<TrainInfo> getAllTrainInfo() {
        return iTrainInfoDAO.getAllTrainInfo();
    }

    @Override
    public TrainInfo getTrainById(int trainid) {
        TrainInfo obj = iTrainInfoDAO.getTrainById(trainid);
        return obj;
    }

    @Override
    public synchronized boolean addTrain(TrainInfo trainInfo) {
        if (iTrainInfoDAO.trainExists(trainInfo.getTrainName(), trainInfo.getCapacity())) {
            return false;
        } else {
            iTrainInfoDAO.addTrain(trainInfo);
            return true;
        }
    }

    @Override
    public void updateTrain(TrainInfo trainInfo) {
        iTrainInfoDAO.updateTrain(trainInfo);
        //iTspInfoDAO.updateTsp(tspInfo);
    }

    @Override
    public void deleteTrain(int trainid) {
        iTrainInfoDAO.deleteTrain(trainid);
    }

}
