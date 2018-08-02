/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.User;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IUserDAO {
      List<User> getAllUser();

    User getUserById(int userid);

    void addUser(User userInfo);

    void updateUser(User userInfo);

    void deleteUser(int userid);
    boolean userLogin(User userInfo);

    boolean userExists(String name, String email);
}

