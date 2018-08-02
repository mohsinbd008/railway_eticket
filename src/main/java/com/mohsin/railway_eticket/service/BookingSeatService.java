/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IBookingSeatDAO;
import com.mohsin.railway_eticket.domain.BookingSeat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class BookingSeatService implements IBookingSeatService {

    @Autowired
    IBookingSeatDAO iBookingSeatDAO;
    
    @Override
    public List<BookingSeat> getAllBookingSeat() {
        return iBookingSeatDAO.getAllBookingSeat();
    }
    
    @Override
    public BookingSeat getBookingSeatById(int id) {
        BookingSeat bs = iBookingSeatDAO.getBookingSeatById(id);
        return bs;
    }
    
    @Override
    public synchronized boolean addBookingSeat(BookingSeat obj) {
        if (iBookingSeatDAO.bookingSeatExists(obj.getSeatNo())) {
            return false;
        } else {
            iBookingSeatDAO.addBookingSeate(obj);
            return true;
        }
        
    }
    
    @Override
    public void updateBookingSeat(BookingSeat obj) {
        iBookingSeatDAO.updateBookingSeat(obj);
        
    }
    
    @Override
    public void deleteBookingSeat(int id) {
        iBookingSeatDAO.deleteBookingSeat(id);
        
    }
    
}
