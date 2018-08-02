/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.Route;
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
public class RouteInfoDAO implements IRouteInfoDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Route> getAllRouteInfo() {
        String hql = "FROM Route as route ORDER BY route.routeId";
        return (List<Route>) hibernateTemplate.find(hql);
    }

    @Override
    public Route getRouteById(int routeid) {
        return hibernateTemplate.get(Route.class, routeid);
    }

    @Override
    public void addRoute(Route routeInfo) {
        hibernateTemplate.save(routeInfo);

    }

    @Override
    public void updateRoute(Route routeInfo) {
        // TrainInfo t = getTrainById(trainInfo.getTrainId());
        // t.setTrainName(trainInfo.getTrainName());
        Route r = getRouteById(routeInfo.getRouteId());
        r.setRouteName(routeInfo.getRouteName());
        r.setRouteNo(routeInfo.getRouteNo());
        r.setSource(routeInfo.getSource());
        r.setDestination(routeInfo.getDestination());
        hibernateTemplate.update(r);

    }

    @Override
    public void deleteRoute(int routeid) {
        hibernateTemplate.delete(getRouteById(routeid));
    }

    @Override
    public boolean routeExists(String name, int route_no) {
        String hql = "FROM Route as p WHERE p.routeName = ? and p.routeNo = ?";
        List<Route> routeList = (List<Route>) hibernateTemplate.find(hql, name, route_no);
        return routeList.size() > 0 ? true : false;

    }
}
