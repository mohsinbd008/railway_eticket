/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.RouteStation;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IRouteStationDAO {

    List<RouteStation> getAllRouteStation();

    RouteStation getRouteStationById(int id);

    void addRouteStation(RouteStation obj);

    void updateRouteStation(RouteStation obj);

    void deleteRouteStation(int id);

    boolean RouteStationExists(int routeId, String station_name);
}
