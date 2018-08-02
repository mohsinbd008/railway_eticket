/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.domain.BookingSeat;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface ISeatBookingService {
     List<BookingSeat> getAllObject();

    BookingSeat getObjectById(int id);

    boolean addObject(BookingSeat obj);

    void updateObject(BookingSeat obj);

    void deleteObject(int id);
}
