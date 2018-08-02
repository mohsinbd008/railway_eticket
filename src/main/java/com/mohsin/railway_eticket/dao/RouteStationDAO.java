/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.RouteStation;
import com.mohsin.railway_eticket.service.IRouteStationService;
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
public class RouteStationDAO implements IRouteStationDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<RouteStation> getAllRouteStation() {
        String hql = "FROM RouteStation p LEFT JOIN FETCH  p.route ORDER BY p.stationId";
        return (List<RouteStation>) hibernateTemplate.find(hql);
    }

    @Override
    public RouteStation getRouteStationById(int id) {
        //   return hibernateTemplate.get(CoachInfo.class, id);
        return hibernateTemplate.get(RouteStation.class, id);

    }

    @Override
    public void addRouteStation(RouteStation obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateRouteStation(RouteStation obj) {
        RouteStation rs = getRouteStationById(obj.getStationId());
        rs.setStationName(obj.getStationName());
        rs.setContactNo(obj.getContactNo());
        rs.setRoute(obj.getRoute());
        hibernateTemplate.update(rs);
    }

    @Override
    public void deleteRouteStation(int id) {
        hibernateTemplate.delete(getRouteStationById(id));
    }

    @Override
    public boolean RouteStationExists(int routeId, String station_name) {
        String hql = "FROM RouteStation as p WHERE p.route.routeId = ? and p.stationName = ?";
        List<RouteStation> stationList = (List<RouteStation>) hibernateTemplate.find(hql, routeId, station_name);
        return stationList.size() > 0 ? true : false;
    }

}
