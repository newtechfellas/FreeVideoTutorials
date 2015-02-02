package com.newtechfellas.videotutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 2/2/15.
 * Time: 4:58 PM
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public ModelAndView home() {
        System.out.println("Inside get for home");
        return new ModelAndView("form");
    }
}
