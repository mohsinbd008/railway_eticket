/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.domain.RouteStation;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IRouteStationService {

    List<RouteStation> getAllRouteStation();

    RouteStation getRouteStationById(int id);

    boolean addRouteStation(RouteStation obj);

    void updateRouteStation(RouteStation obj);

    void deleteRouteStation(int id);
}
