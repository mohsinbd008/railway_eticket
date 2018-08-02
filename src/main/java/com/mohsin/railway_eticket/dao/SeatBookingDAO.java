/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.BookingSeat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohsin
 */
@Repository
@Transactional
public class SeatBookingDAO implements ISeatBookingDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BookingSeat> getAllObject() {
        String hql = "FROM BookingSeat p LEFT JOIN FETCH  p.coachInfo LEFT JOIN FETCH  p.booking ORDER BY p.boSeatId";
        return (List<BookingSeat>) hibernateTemplate.find(hql);
    }

    @Override
    public BookingSeat getObjectById(int id) {
        return hibernateTemplate.get(BookingSeat.class, id);

    }

    @Override
    public void addObject(BookingSeat obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BookingSeat obj) {
        BookingSeat u = getObjectById(obj.getBoSeatId());
        u.setBooking(obj.getBooking());
        u.setCoachInfo(obj.getCoachInfo());
        u.setSeatNo(obj.getBoSeatId());
        hibernateTemplate.update(u);

//        u.setBookingSeatPass(obj.getBookingSeatPass());
//        u.setBookingSeatPhone(obj.getBookingSeatPhone());
//        u.setBookingSeatEmail(obj.getBookingSeatEmail());
//        u.setBookingSeatAddress(obj.getBookingSeatAddress());
//        u.setBookingSeatType(obj.getBookingSeatType());
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean ObjectExists(int seatNo, int coachId) {
        String hql = "FROM BookingSeat as p WHERE p.seatNo = ? and p.coachInfo.coachId = ?";
        List<BookingSeat> coachList = (List<BookingSeat>) hibernateTemplate.find(hql, seatNo, coachId);
        return coachList.size() > 0 ? true : false;

    }

}
