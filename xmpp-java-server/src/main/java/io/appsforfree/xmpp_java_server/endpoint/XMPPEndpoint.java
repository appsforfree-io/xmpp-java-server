package io.appsforfree.xmpp_java_server.endpoint;

import java.io.IOException;
import java.util.UUID;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import io.appsforfree.xmpp_java_server.common.domain.Stream;
import io.appsforfree.xmpp_java_server.common.domain.decoder.StreamDecoder;
import io.appsforfree.xmpp_java_server.common.domain.encoder.StreamEncoder;

@ServerEndpoint(value = "/xmpp", decoders = StreamDecoder.class, encoders = StreamEncoder.class )
public class XMPPEndpoint {
 
    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
    	System.out.println("Connected !");
    }
 
    @OnMessage
    public void handleStream(Stream stream, Session session) throws IOException {
    	try {
    		UUID uuid = UUID.randomUUID();
    		stream.setId(uuid.toString());
			session.getBasicRemote().sendObject(stream);
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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