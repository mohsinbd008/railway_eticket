/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.TrainInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohsin
 */
@Repository
@Transactional
public class TrainInfoDAO implements ITrainInfoDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public TrainInfoDAO() {
        System.out.println("TrainInfoDAO........................");
    }
    
    

    @Override
    public List<TrainInfo> getAllTrainInfo() {
        String hql = "FROM TrainInfo as train ORDER BY train.trainId";
        return (List<TrainInfo>) hibernateTemplate.find(hql);

    }

    @Override
    public TrainInfo getTrainById(int trainid) {
        return hibernateTemplate.get(TrainInfo.class, trainid);
    }

    @Override
    public void addTrain(TrainInfo trainInfo) {
        hibernateTemplate.save(trainInfo);

    }

    @Override
    public void updateTrain(TrainInfo trainInfo) {
        TrainInfo t = getTrainById(trainInfo.getTrainId());
        t.setTrainName(trainInfo.getTrainName());
        t.setTrainType(trainInfo.getTrainType());
        t.setOffDay(trainInfo.getOffDay());
        t.setCapacity(trainInfo.getCapacity());
        t.setCoachInfos(trainInfo.getCoachInfos());
        t.setTrainSchedules(trainInfo.getTrainSchedules());
        hibernateTemplate.update(t);
    

}

@Override
        public void deleteTrain(int trainid) {
       hibernateTemplate.delete(getTrainById(trainid));
    }

    @Override
        public boolean trainExists(String name, int capacity) {
         String hql = "FROM TrainInfo as p WHERE p.trainName = ? and p.capacity = ?";
        List<TrainInfo> trainList = (List<TrainInfo>) hibernateTemplate.find(hql, name, capacity);
        return trainList.size() > 0 ? true : false;
    }
    
}
