package io.appsforfree.xmpp_java_server.endpoint;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import io.appsforfree.xmpp_java_server.business.MessageManager;
import io.appsforfree.xmpp_java_server.business.SessionManager;
import io.appsforfree.xmpp_java_server.business.StreamManager;
import io.appsforfree.xmpp_java_server.common.domain.Message;
import io.appsforfree.xmpp_java_server.common.domain.Stream;
import io.appsforfree.xmpp_java_server.common.domain.decoder.MessageDecoder;
import io.appsforfree.xmpp_java_server.common.domain.encoder.MessageEncoder;
import io.appsforfree.xmpp_java_server.common.domain.decoder.StreamDecoder;
import io.appsforfree.xmpp_java_server.common.domain.encoder.StreamEncoder;

@ServerEndpoint(
		value = "/xmpp", 
		decoders = { StreamDecoder.class, MessageDecoder.class }, 
		encoders = { StreamEncoder.class, MessageEncoder.class } 
		)
public class XMPPEndpoint {
 
	private StreamManager streamManager;
	private MessageManager messageManager;
	
    @OnOpen
    public void onOpen(Session session) throws IOException {
        if (streamManager == null) {
        	// TODO: Improve with dependency injection
        	SessionManager sessionManager = new SessionManager();
        	streamManager = new StreamManager(sessionManager);
        	messageManager = new MessageManager(sessionManager);
        }
    }
 
    @OnMessage
    public void handleStream(Stream stream, Session session) throws IOException {
    	try {
    		streamManager.handle(stream, session);
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @OnMessage
    public void handleMessage(Message message, Session session) throws IOException {
    	try {
    		messageManager.handle(message);
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