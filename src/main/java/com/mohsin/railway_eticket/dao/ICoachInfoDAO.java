/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.CoachInfo;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface ICoachInfoDAO {
    List<CoachInfo> getAllCoach();

    CoachInfo getCoachById(int id);

   void addCoach(CoachInfo obj);

    void updateCoach(CoachInfo obj);

    void deleteCoach(int id);
       boolean CoachExists(int trainId, String totalseat);
}
