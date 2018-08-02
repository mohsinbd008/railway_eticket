/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.ISeatBookingDAO;
import com.mohsin.railway_eticket.domain.BookingSeat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class SeatBookingService implements ISeatBookingService {

    @Autowired
    private ISeatBookingDAO iSeatBookingDAO;


    @Override
    public List<BookingSeat> getAllObject() {
    return iSeatBookingDAO.getAllObject();
    }

    @Override
    public BookingSeat getObjectById(int id) {
         BookingSeat u = iSeatBookingDAO.getObjectById(id);
        return u;
    }

    @Override
    public synchronized boolean addObject(BookingSeat obj) {
        if (iSeatBookingDAO.ObjectExists(obj.getSeatNo(), obj.getCoachInfo().getCoachId())) {
            return false;
        } else {
            iSeatBookingDAO.addObject(obj);
            return true;
        }
       
    }

    @Override
    public void updateObject(BookingSeat obj) {
        iSeatBookingDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
       iSeatBookingDAO.deleteObject(id);
    }
}
