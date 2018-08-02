/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.UserType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R-34
 */
@Repository
@Transactional
public class UserTypeDAO implements IUserTypeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<UserType> getAllUserType() {
        String hql = "FROM UserType as utype ORDER BY utype.UTypeId";
        return (List<UserType>) hibernateTemplate.find(hql);
    }

    @Override
    public UserType getUserTypeById(int utypeid) {
        return hibernateTemplate.get(UserType.class, utypeid);
    }

    @Override
    public void addUserType(UserType utypeInfo) {
        hibernateTemplate.save(utypeInfo);
    }

    @Override
    public void updateUserType(UserType utypeInfo) {
        UserType t = getUserTypeById(utypeInfo.getUTypeId());
        t.setUTypeName(utypeInfo.getUTypeName());
        t.setUsers(utypeInfo.getUsers());

        hibernateTemplate.update(t);
    }

    @Override
    public void deleteUserType(int utypeid) {
        hibernateTemplate.delete(getUserTypeById(utypeid));
    }

    @Override
    public boolean userTypeExists(String name) {
        String hql = "FROM UserType as p WHERE p.UTypeName = ?";
        List<UserType> utypeList = (List<UserType>) hibernateTemplate.find(hql, name);
        return utypeList.size() > 0 ? true : false;

    }
}
