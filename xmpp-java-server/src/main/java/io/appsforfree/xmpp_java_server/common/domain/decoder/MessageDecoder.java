package io.appsforfree.xmpp_java_server.common.domain.decoder;

import io.appsforfree.xmpp_java_server.common.domain.Message;

import java.io.StringReader;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MessageDecoder implements Decoder.Text<Message> {

	@Override
	public void init(EndpointConfig config) { }

	@Override
	public void destroy() { }

	@Override
	public Message decode(String s) throws DecodeException {
		Message message = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(Message.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			message = (Message)unmarshaller.unmarshal(new StringReader(s));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public boolean willDecode(String s) {
		return s.startsWith("<message");
	}

}
