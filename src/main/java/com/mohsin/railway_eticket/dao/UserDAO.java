/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.dao;

import com.mohsin.railway_eticket.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohsin
 */
@Repository
@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<User> getAllUser() {
        String hql = "FROM User p LEFT JOIN FETCH  p.userType ORDER BY p.userId";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User getUserById(int userid) {
        return hibernateTemplate.get(User.class, userid);

    }
    
    @Override
    public boolean userLogin(User u) {
        String hql = "FROM User p WHERE p.userName=? AND p.userPass=?";
        List<User> userList= (List<User>) hibernateTemplate.find(hql,u.getUserName(), u.getUserPass());
        if(userList.size()>0)
            return true;
        else 
            return false;
    }

    @Override
    public void addUser(User userInfo) {
        hibernateTemplate.save(userInfo);
    }

    @Override
    public void updateUser(User userInfo) {
        User u = getUserById(userInfo.getUserId());
        u.setUserName(userInfo.getUserName());
        u.setUserPass(userInfo.getUserPass());
        u.setUserPhone(userInfo.getUserPhone());
        u.setUserEmail(userInfo.getUserEmail());
        u.setUserAddress(userInfo.getUserAddress());
        u.setUserType(userInfo.getUserType());
    }

    @Override
    public void deleteUser(int userid) {
        hibernateTemplate.delete(getUserById(userid));
    }

    @Override
    public boolean userExists(String name, String email) {
        String hql = "FROM User as p WHERE p.userType.UTypeName = ? and p.userEmail = ?";
        List<User> coachList = (List<User>) hibernateTemplate.find(hql, name, email);
        return coachList.size() > 0 ? true : false;
    }

}
