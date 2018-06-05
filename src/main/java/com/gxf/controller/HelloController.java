package com.gxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by GuanXF on 2018/3/5.
 */
@RestController
@RequestMapping("/web")
public class HelloController {

    @RequestMapping("/client")
    public ModelAndView toHelloHtml(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("client request");
        modelAndView.setViewName("client");
        return modelAndView;
    }

    @RequestMapping("/index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("client request");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
