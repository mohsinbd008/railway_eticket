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
public class BookingSeatDAO implements IBookingSeatDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BookingSeat> getAllBookingSeat() {
        String hql = "FROM BookingSeat p LEFT JOIN FETCH  p.booking LEFT JOIN FETCH  p.coachInfo ORDER BY p.boSeatId";
        // String hql = "FROM TrainSchedule as schedule ORDER BY schedule.scheduleId";
        return (List<BookingSeat>) hibernateTemplate.find(hql);
    }

    @Override
    public BookingSeat getBookingSeatById(int seatid) {
        return hibernateTemplate.get(BookingSeat.class, seatid);
    }

    @Override
    public void addBookingSeate(BookingSeat seatInfo) {
        hibernateTemplate.save(seatInfo);

    }

    @Override
    public void updateBookingSeat(BookingSeat seatInfo) {
        BookingSeat bs = getBookingSeatById(seatInfo.getBoSeatId());
        bs.setBooking(seatInfo.getBooking());
        bs.setCoachInfo(seatInfo.getCoachInfo());
        bs.setSeatNo(seatInfo.getBoSeatId());
        hibernateTemplate.update(bs);

    }

    @Override
    public void deleteBookingSeat(int seatid) {
        hibernateTemplate.delete(getBookingSeatById(seatid));

    }

    @Override
    public boolean bookingSeatExists(int seat_no) {
        String hql = "FROM BookingSeat as p WHERE p.seatNo = ?";
        List<BookingSeat> bookingList = (List<BookingSeat>) hibernateTemplate.find(hql, seat_no);
        return bookingList.size() > 0 ? true : false;

    }

}
