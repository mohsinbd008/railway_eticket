/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.Booking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R-34
 */
@Repository
@Transactional
public class BookingDAO implements IBookingDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Booking> getAllBooking() {
        String hql = "FROM Booking p LEFT JOIN FETCH  p.user LEFT JOIN FETCH  p.trainSchedule ORDER BY p.bookId";
        // String hql = "FROM TrainSchedule as schedule ORDER BY schedule.scheduleId";
        return (List<Booking>) hibernateTemplate.find(hql);
    }

    @Override
    public Booking getBookingById(int seatid) {
        return hibernateTemplate.get(Booking.class, seatid);
    }

    @Override
    public void addBooking(Booking seatInfo) {
//        Booking booking =new Booking();
//        double totalprice=seatInfo.getTotalPrice();
//        Integer bookedTcket=seatInfo.getTBookedSeat();
//        if(bookedTcket<=4){
//             booking.setBookDate(seatInfo.getBookDate());
//        booking.setBookStatus(seatInfo.getBookStatus());
//        booking.setTBookedSeat(seatInfo.getTBookedSeat());
//        booking.setUser(seatInfo.getUser());
//        booking.setTrainSchedule(seatInfo.getTrainSchedule());
//        booking.setPaymentStatus(seatInfo.getPaymentStatus());
//        booking.setTotalPrice(seatInfo.getTotalPrice());
//        booking.setTicketNumber(seatInfo.getTicketNumber());
//      
//        }
        Booking pa = new Booking();
        double ticketPrice = seatInfo.getCoachInfo().getTicketPrice();
        Integer tBookedSeat = seatInfo.getTBookedSeat();
        if (tBookedSeat <= 4) {
            pa.setBookDate(seatInfo.getBookDate());
            pa.setBookStatus(seatInfo.getBookStatus());
            pa.setTBookedSeat(seatInfo.getTBookedSeat());
            pa.setUser(seatInfo.getUser());
            pa.setTrainSchedule(seatInfo.getTrainSchedule());
            pa.setPaymentStatus(seatInfo.getPaymentStatus());
            pa.setCoachInfo(seatInfo.getCoachInfo());
            pa.setTotalPrice(tBookedSeat * ticketPrice);
            pa.setTBookedSeat(tBookedSeat);
        }
        hibernateTemplate.save(pa);
    }

    @Override
    public void updateBooking(Booking seatInfo) {
        Booking b = getBookingById(seatInfo.getBookId());
        b.setBookDate(seatInfo.getBookDate());
        b.setBookStatus(seatInfo.getBookStatus());
        b.setTBookedSeat(seatInfo.getTBookedSeat());
        b.setUser(seatInfo.getUser());
        b.setTrainSchedule(seatInfo.getTrainSchedule());
        b.setPaymentStatus(seatInfo.getPaymentStatus());
        b.setTotalPrice(seatInfo.getTotalPrice());
        b.setTicketNumber(seatInfo.getTicketNumber());
        hibernateTemplate.update(b);

    }

    @Override
    public void deleteBooking(int seatid) {
        hibernateTemplate.delete(getBookingById(seatid));

    }

    @Override
    public boolean bookingExists(int ticketNumber) {
        String hql = "FROM Booking as p WHERE p.ticketNumber = ?";
        List<Booking> bookingList = (List<Booking>) hibernateTemplate.find(hql, ticketNumber);
        return bookingList.size() > 0 ? true : false;
    }

}
