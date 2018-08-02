/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.UserType;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IUserTypeDAO {

    List<UserType> getAllUserType();

    UserType getUserTypeById(int utypeid);

    void addUserType(UserType utypeInfo);

    void updateUserType(UserType utypeInfo);

    void deleteUserType(int utypeid);

    boolean userTypeExists(String name);
}
