/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.Booking;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IBookingDAO {
       List<Booking> getAllBooking();

    Booking getBookingById(int seatid);

    void addBooking(Booking seatInfo);

    void updateBooking(Booking seatInfo);

    void deleteBooking(int seatid);

    boolean bookingExists(int ticketNumber);
}
