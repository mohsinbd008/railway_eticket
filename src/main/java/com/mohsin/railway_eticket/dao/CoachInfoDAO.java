/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.CoachInfo;
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
public class CoachInfoDAO implements ICoachInfoDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<CoachInfo> getAllCoach() {
        String hql = "FROM CoachInfo p LEFT JOIN FETCH  p.trainInfo ORDER BY p.coachId";
        return (List<CoachInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public CoachInfo getCoachById(int id) {
        return hibernateTemplate.get(CoachInfo.class, id);

    }

    @Override
    public void addCoach(CoachInfo obj) {
        hibernateTemplate.save(obj);

    }

    @Override
    public void updateCoach(CoachInfo obj) {
        CoachInfo c = getCoachById(obj.getCoachId());
        // TrainInfo t = getTrainById(trainInfo.getTrainId());
        c.setCoachName(obj.getCoachName());
        c.setCoachType(obj.getCoachType());
        c.setTicketPrice(obj.getTicketPrice());
        c.setTotalSeat(obj.getTotalSeat());
        c.setTrainInfo(obj.getTrainInfo());
        hibernateTemplate.update(c);

    }

    @Override
    public void deleteCoach(int id) {
        hibernateTemplate.delete(getCoachById(id));

    }

    @Override
    public boolean CoachExists(int trainId, String totalseat) {
        String hql = "FROM CoachInfo as p WHERE p.trainInfo.trainId = ? and p.totalSeat = ?";
        List<CoachInfo> coachList = (List<CoachInfo>) hibernateTemplate.find(hql, trainId, totalseat);
        return coachList.size() > 0 ? true : false;

    }

}
