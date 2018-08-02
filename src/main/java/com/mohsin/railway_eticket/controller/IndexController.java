/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohsin.railway_eticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Faculty
 */
//@RestController
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        //        return "Welcome to RestTemplate Example.";
        return "index";
    }
}
