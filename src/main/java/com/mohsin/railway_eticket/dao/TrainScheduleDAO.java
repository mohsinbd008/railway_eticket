/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.TrainSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R-34
 */
@Repository
@Transactional
public class TrainScheduleDAO implements ITrainScheduleDAO{
      @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<TrainSchedule> getAllObject() {
         String hql = "FROM TrainSchedule p LEFT JOIN FETCH  p.trainInfo LEFT JOIN FETCH  p.route ORDER BY p.scheduleId";
        return (List<TrainSchedule>) hibernateTemplate.find(hql);
    }

    @Override
    public TrainSchedule getObjectById(int id) {
          return hibernateTemplate.get(TrainSchedule.class, id);
    }

    @Override
    public void addObject(TrainSchedule obj) {
          hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(TrainSchedule obj) {
        TrainSchedule u = getObjectById(obj.getScheduleId());
        u.setDeparDate(obj.getDeparDate());
        u.setDeparTime(obj.getDeparTime());
        u.setTrainInfo(obj.getTrainInfo());
        u.setRoute(obj.getRoute());
        hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
          hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean ObjectExists(String timee) {
           String hql = "FROM TrainSchedule as p WHERE p.deparTime = ?";
        List<TrainSchedule> coachList = (List<TrainSchedule>) hibernateTemplate.find(hql, timee);
        return coachList.size() > 0 ? true : false;
    }
    
}
