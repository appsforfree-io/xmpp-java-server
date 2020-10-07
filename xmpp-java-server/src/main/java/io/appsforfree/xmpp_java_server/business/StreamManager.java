package io.appsforfree.xmpp_java_server.business;

import java.io.IOException;
import java.util.UUID;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import io.appsforfree.xmpp_java_server.common.domain.Stream;

public class StreamManager {
	
	private SessionManager sessionManager;
	
	public StreamManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
	public void handle(Stream stream, Session session) throws EncodeException, IOException {
		sessionManager.addSession(session, stream.getFrom());
		UUID uuid = UUID.randomUUID();
		stream.setId(uuid.toString());
		session.getBasicRemote().sendObject(stream);
	}
	
}
