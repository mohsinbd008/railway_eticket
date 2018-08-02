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
public interface IBookingSeatService {

    List<BookingSeat> getAllBookingSeat();

    BookingSeat getBookingSeatById(int id);

    boolean addBookingSeat(BookingSeat obj);

    void updateBookingSeat(BookingSeat obj);

    void deleteBookingSeat(int id);
}
