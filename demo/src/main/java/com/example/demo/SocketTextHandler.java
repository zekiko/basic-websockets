package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;



@Component
public class SocketTextHandler extends TextWebSocketHandler {

    public static List<WebSocketSession> sessionList = new ArrayList<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
//        for (WebSocketSession webSocketSession : sessionList) {
//            session.sendMessage(new TextMessage(message.getPayload()));
//        }
        session.sendMessage(new TextMessage(message.getPayload()));

    }
}
