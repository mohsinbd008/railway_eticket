/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IRouteInfoDAO;
import com.mohsin.railway_eticket.domain.Route;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class RouteInfoService implements IRouteInfoService {

    @Autowired
    private IRouteInfoDAO iRouteInfoDAO;

    @Override
    public List<Route> getAllRoute() {
        return iRouteInfoDAO.getAllRouteInfo();
    }

    @Override
    public Route getRouteById(int routeid) {
        Route obj = iRouteInfoDAO.getRouteById(routeid);
        return obj;
    }

    @Override
    public synchronized boolean addRoute(Route routeInfo) {
        if (iRouteInfoDAO.routeExists(routeInfo.getRouteName(), routeInfo.getRouteNo())) {
            return false;
        } else {
            iRouteInfoDAO.addRoute(routeInfo);
            return true;
        }

    }

    @Override
    public void updateRoute(Route routeInfo) {
        iRouteInfoDAO.updateRoute(routeInfo);
    }

    @Override
    public void deleteRoute(int routeid) {
        iRouteInfoDAO.deleteRoute(routeid);

    }

}
