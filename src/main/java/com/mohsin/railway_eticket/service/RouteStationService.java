/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IRouteStationDAO;
import com.mohsin.railway_eticket.domain.RouteStation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class RouteStationService implements IRouteStationService {

    @Autowired
    private IRouteStationDAO iRouteStationDAO;
    
    @Override
    public List<RouteStation> getAllRouteStation() {
        return iRouteStationDAO.getAllRouteStation();
        
    }
    
    @Override
    public RouteStation getRouteStationById(int id) {
        RouteStation obj = iRouteStationDAO.getRouteStationById(id);
        return obj;
    }
    
    @Override
    public synchronized boolean addRouteStation(RouteStation obj) {
        if (iRouteStationDAO.RouteStationExists(obj.getRoute().getRouteId(), obj.getStationName())) {
            return false;
        } else {
            iRouteStationDAO.addRouteStation(obj);
            return true;
        }
        
    }
    
    @Override
    public void updateRouteStation(RouteStation obj) {
        iRouteStationDAO.updateRouteStation(obj);
    }
    
    @Override
    public void deleteRouteStation(int id) {
        iRouteStationDAO.deleteRouteStation(id);
    }
    
}
