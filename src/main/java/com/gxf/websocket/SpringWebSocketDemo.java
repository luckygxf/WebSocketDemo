package com.gxf.websocket;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 58 on 2018/6/8.
 */
@ServerEndpoint(value = "/springWebSocketDemo", configurator = SpringConfigurator.class)
public class SpringWebSocketDemo {
    private static int onlineCount = 0;

    private static Map<Long, Set<SpringWebSocketDemo>> userSocket = new HashMap<Long, Set<SpringWebSocketDemo>>();

    private Session session;
    private Long userId;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        onlineCount ++;
        System.out.println("onPen method running ...");
    }

    @OnClose
    public void onClose(){
        System.out.println("onClose method running ...");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        this.session = session;
        System.out.println("Receive msg: " + message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("onError method running ...");
        error.printStackTrace();
    }

    public Boolean sendMessageToUser(Long userId, String message){
        System.out.println("sendMessageToUser method running ...");
        return true;
    }

}
