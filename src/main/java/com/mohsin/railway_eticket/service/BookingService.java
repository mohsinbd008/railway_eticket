/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IBookingDAO;
import com.mohsin.railway_eticket.domain.Booking;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class BookingService implements IBookingService {

    @Autowired
    IBookingDAO iBookingDAO;

    @Override
    public List<Booking> getAllBooking() {
        return iBookingDAO.getAllBooking();
    }

    @Override
    public Booking getBookingById(int id) {
        Booking b = iBookingDAO.getBookingById(id);
        return b;
    }

    @Override
    public synchronized boolean addBooking(Booking obj) {
        if (iBookingDAO.bookingExists(obj.getTicketNumber())) {
            return false;
        } else {
          //  obj.setBookDate(new Date());
            iBookingDAO.addBooking(obj);
            
            return true;
        }

    }

    @Override
    public void updateBooking(Booking obj) {
        iBookingDAO.updateBooking(obj);
    }

    @Override
    public void deleteBooking(int id) {
        iBookingDAO.deleteBooking(id);

    }

}
