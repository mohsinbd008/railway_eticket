/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.service;

import com.mohsin.railway_eticket.dao.IUserTypeDAO;
import com.mohsin.railway_eticket.domain.UserType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class UserTypeService implements IUserTypeService {

    @Autowired
    private IUserTypeDAO iUserTypeDAO;

    @Override
    public List<UserType> getAllUserType() {
        return iUserTypeDAO.getAllUserType();
    }

    @Override
    public UserType getUserTypeById(int utypeid) {
        UserType obj = iUserTypeDAO.getUserTypeById(utypeid);
        return obj;
    }

    @Override
    public synchronized boolean addUserType(UserType utypeInfo) {
        if (iUserTypeDAO.userTypeExists(utypeInfo.getUTypeName())) {
            return false;
        } else {
            iUserTypeDAO.addUserType(utypeInfo);
            return true;
        }
    }

    @Override
    public void updateUserType(UserType utypeInfo) {
        iUserTypeDAO.updateUserType(utypeInfo);
        //iTspInfoDAO.updateTsp(tspInfo);
    }

    @Override
    public void deleteUserType(int utypeid) {
        iUserTypeDAO.deleteUserType(utypeid);
    }

}
