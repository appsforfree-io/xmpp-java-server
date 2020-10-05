package io.appsforfree.xmpp_java_server.endpoint;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/xmpp")
public class XMPPEndpoint {
 
    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
    	System.out.println("Connected !");
    }
 
    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // Handle new messages
    	System.out.println("Message received : " + message);
    }
 
    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
    	System.out.println("Disconnected !");
    }
 
    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    	System.out.println("Error !");
    }
}