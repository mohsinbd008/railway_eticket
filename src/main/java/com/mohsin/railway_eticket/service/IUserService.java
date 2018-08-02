/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.domain.User;
import java.util.List;

/**
 *
 * @author Mohsin
 */
public interface IUserService {

    List<User> getAllUser();

    User getUserById(int id);

    boolean addUser(User obj);

    boolean userLogin(User obj);

    void updateUser(User obj);

    void deleteUser(int id);
}
