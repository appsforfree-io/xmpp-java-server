package io.appsforfree.xmpp_java_server.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.Session;

public class SessionManager {
	
	private Map<String, Set<Session>> sessions;
	
	public SessionManager() {
		sessions = new HashMap<String, Set<Session>>();
	}
	
	public void addSession(Session session, String user) {
		if (sessions.containsKey(user)) {
			sessions.get(user).add(session);
		} else {
			sessions.put(user, new HashSet<Session>(Arrays.asList(session)) );
		}
	}
	
	public Set<Session> getSessions(String user) {
		return sessions.get(user);
	}
	
}
