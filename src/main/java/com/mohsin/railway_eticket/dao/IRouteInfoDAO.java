/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.Route;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IRouteInfoDAO {
     List<Route> getAllRouteInfo();

    Route getRouteById(int routeid);

    void addRoute(Route routeInfo);

    void updateRoute(Route routeInfo);

    void deleteRoute(int routeid);

    boolean routeExists(String name, int route_no);
}
