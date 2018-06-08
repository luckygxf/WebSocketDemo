package com.gxf.service;

import com.gxf.websocket.SpringWebSocketDemo;

/**
 * Created by 58 on 2018/6/8.
 */
public class WSMessageService {
    private SpringWebSocketDemo springWebSocketDemo = new SpringWebSocketDemo();

    public Boolean sendToAllTerminal(Long userId, String message){
        return springWebSocketDemo.sendMessageToUser(userId, message);
    }

}
