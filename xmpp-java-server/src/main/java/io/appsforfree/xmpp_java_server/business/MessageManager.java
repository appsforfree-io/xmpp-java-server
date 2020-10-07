package io.appsforfree.xmpp_java_server.business;

import java.io.IOException;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import io.appsforfree.xmpp_java_server.common.domain.Message;

public class MessageManager {
	
	private SessionManager sessionManager;
	
	public MessageManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
	public void handle(Message message) throws IOException, EncodeException {
		Set<Session> sessions = sessionManager.getSessions(message.getTo());
		for (Session session: sessions)
			session.getBasicRemote().sendObject(message);
	}
	
}
