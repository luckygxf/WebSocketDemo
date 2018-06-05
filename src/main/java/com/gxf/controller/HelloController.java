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

    @RequestMapping("/websocket")
    public ModelAndView toHelloHtml(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("websocket");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
