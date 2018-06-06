package com.gxf.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by 58 on 2018/6/5.
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {
    //当前连接数
    private static int onlineCount = 0;
    //保存每个客服端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
    //与客户端的连接会话，通过session给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        System.out.println("onOpen " + session + ", " + session.getProtocolVersion());
        this.session = session;
        webSocketSet.add(this);

    }

    @OnClose
    public void onClose(){
        System.out.println("onClose");
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("来自客户端的消息：" + message);
        //群发消息
        for(WebSocketTest item : webSocketSet){
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }


    /**
     * 发送消息
     * */
    public void sendMessage(String message) throws IOException{
        System.out.println("sendMessage : " + message);
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized void addOnlineCount(){
        WebSocketTest.onlineCount ++;
    }

    public static synchronized void subOnlineCount(){
        WebSocketTest.onlineCount --;
    }

    public static synchronized int getOnlineCount(){
        return WebSocketTest.onlineCount;
    }
}
