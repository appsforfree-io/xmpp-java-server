package io.appsforfree.xmpp_java_server.common.domain.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import io.appsforfree.xmpp_java_server.common.domain.Message;

public class MessageEncoder implements Encoder.Text<Message> {

	@Override
	public void init(EndpointConfig config) { }

	@Override
	public void destroy() { }

	@Override
	public String encode(Message object) throws EncodeException {
		return null;
	}

}
