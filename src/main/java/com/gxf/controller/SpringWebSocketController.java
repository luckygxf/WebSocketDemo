package com.gxf.controller;

import com.gxf.service.WSMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 58 on 2018/6/8.
 */
@Controller
@RequestMapping("/message")
public class SpringWebSocketController {

    @Autowired
    private WSMessageService wsMessageService;

    public String testWS(){
        Long userId = 1L;
        private String message = "hello spring websocket.";
        if(wsMessageService.sendToAllTerminal(userId, message)){
            return "Send success";
        }else{
            return "Send faild.";
        }
    }

}
