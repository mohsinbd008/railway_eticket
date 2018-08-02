/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.BookingSeat;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IBookingSeatDAO {

    List<BookingSeat> getAllBookingSeat();

    BookingSeat getBookingSeatById(int seatid);

    void addBookingSeate(BookingSeat seatInfo);

    void updateBookingSeat(BookingSeat seatInfo);

    void deleteBookingSeat(int seatid);

    boolean bookingSeatExists(int seat_no);

}
