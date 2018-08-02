/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IUserDAO;
import com.mohsin.railway_eticket.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohsin
 */
@Service
public class UserService implements IUserService{
    
    @Autowired
    private IUserDAO iUserDAO;

    @Override
    public List<User> getAllUser() {
      return iUserDAO.getAllUser();
    }

    @Override
    public User getUserById(int id) {
       User u=iUserDAO.getUserById(id);
       return u;
    }

    @Override
    public synchronized boolean addUser(User obj) {
          if (iUserDAO.userExists(obj.getUserType().getUTypeName(), obj.getUserEmail())) {
            return false;
        } else {
            iUserDAO.addUser(obj);
            return true;
        }
     
    }
       @Override
    public boolean userLogin(User obj) {
         return iUserDAO.userLogin(obj); 
    }

    @Override
    public void updateUser(User obj) {
        iUserDAO.updateUser(obj);
 
    }

    @Override
    public void deleteUser(int id) {
     iUserDAO.deleteUser(id);
    }
    
}
