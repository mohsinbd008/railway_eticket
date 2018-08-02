/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.domain.Booking;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IBookingService {

    List<Booking> getAllBooking();

    Booking getBookingById(int id);

    boolean addBooking(Booking obj);

    void updateBooking(Booking obj);

    void deleteBooking(int id);
}
