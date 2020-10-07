package io.appsforfree.xmpp_java_server.common.domain.decoder;

import io.appsforfree.xmpp_java_server.common.domain.Stream;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class StreamDecoder implements Decoder.Text<Stream> {
	
	@Override
	public Stream decode(String message) throws DecodeException {
		Stream stream = new Stream();
		String[] chunks = message.split(" ");
		for (int i = 1; i < chunks.length; i++) {
			String chunk = chunks[i];
			String[] attributes = chunk.strip().split("=");
			if (attributes[0].equals("to")) {
				stream.setTo(attributes[1].replace("'", ""));
			} else if (attributes[0].equals("from")) {
				stream.setFrom(attributes[1].replace("'", ""));
			} else if (attributes[0].equals("id")) {
				stream.setId(attributes[1].replace("'", ""));
			}
		}
	    return stream;
    }
	
	@Override
	public boolean willDecode(String message) {
		return message.startsWith("<stream:stream");
	}

	@Override
	public void init(EndpointConfig config) {  }
	
	@Override
	public void destroy() {  }
	
}
