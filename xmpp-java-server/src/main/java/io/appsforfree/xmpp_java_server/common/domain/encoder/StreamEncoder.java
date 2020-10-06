package io.appsforfree.xmpp_java_server.common.domain.encoder;

import io.appsforfree.xmpp_java_server.common.domain.Stream;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class StreamEncoder implements Encoder.Text<Stream> {

	@Override
	public void init(EndpointConfig config) { }

	@Override
	public void destroy() { }

	@Override
	public String encode(Stream object) throws EncodeException {
		return "<stream:stream from=\'" + object.getFrom() + "\' to=\'" + object.getTo() + "\' id=\'" + object.getId() + "\'>";
	}

}
