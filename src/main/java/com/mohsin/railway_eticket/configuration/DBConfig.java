/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.configuration;

import com.mohsin.railway_eticket.domain.Booking;
import com.mohsin.railway_eticket.domain.Route;
import com.mohsin.railway_eticket.domain.BookingSeat;
import com.mohsin.railway_eticket.domain.CoachInfo;
import com.mohsin.railway_eticket.domain.RouteStation;
import com.mohsin.railway_eticket.domain.TrainInfo;
import com.mohsin.railway_eticket.domain.TrainSchedule;
import com.mohsin.railway_eticket.domain.User;
import com.mohsin.railway_eticket.domain.UserType;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Faculty
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory().getObject());
    }

//    @Bean
//    public SessionFactory sessionFactory() {
//        return new LocalSessionFactoryBuilder(getDataSource())
//                .addAnnotatedClasses(Person.class, BatchInfo.class, ExamMarks.class
//                ,ExamSchedule.class,LoginInfo.class, StudentInfo.class,  StudentJobStatus.class
//                , TspFaculty.class, TspInfo.class, TspTc.class, UserRole.class)                               
//                .buildSessionFactory();
//        
//    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.mohsin.railway_eticket.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/final_project");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        return dataSource;
    }

//    @Bean
//    public HibernateTransactionManager hibTransMan() {
//        return new HibernateTransactionManager(sessionFactory());
//    }
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        return properties;        
    }
}
