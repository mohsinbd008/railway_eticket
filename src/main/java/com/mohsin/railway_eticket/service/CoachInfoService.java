/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.ICoachInfoDAO;
import com.mohsin.railway_eticket.domain.CoachInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class CoachInfoService implements ICoachInfoService {

    @Autowired
    private ICoachInfoDAO iCoachInfoDAO;

    @Override
    public List<CoachInfo> getAllCoach() {
        return iCoachInfoDAO.getAllCoach();
    }

    @Override
    public CoachInfo getCoachById(int id) {
        CoachInfo obj = iCoachInfoDAO.getCoachById(id);
        return obj;
    }

    @Override
    public synchronized boolean addCoach(CoachInfo obj) {
          if (iCoachInfoDAO.CoachExists(obj.getTrainInfo().getTrainId(), obj.getTotalSeat())) {
            return false;
        } else {
            iCoachInfoDAO.addCoach(obj);
            return true;
        }
//        if (iCoachInfoDAO.CoachExists(obj.getCoachName(), obj.getTotalSeat())) {
//            return false;
//        } else {
//            iCoachInfoDAO.addCoach(obj);
//            return true;
//        }
    }


    @Override
    public void updateCoach(CoachInfo obj) {
        iCoachInfoDAO.updateCoach(obj);
    }

    @Override
    public void deleteCoach(int id) {
        iCoachInfoDAO.deleteCoach(id);
    }

}
