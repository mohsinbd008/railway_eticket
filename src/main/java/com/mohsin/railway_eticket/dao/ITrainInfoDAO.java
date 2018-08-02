/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.TrainInfo;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface ITrainInfoDAO {

    List<TrainInfo> getAllTrainInfo();

    TrainInfo getTrainById(int trainid);

    void addTrain(TrainInfo trainInfo);

    void updateTrain(TrainInfo trainInfo);

    void deleteTrain(int trainid);

    boolean trainExists(String name, int capacity);
}
