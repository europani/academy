package webSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/weball")
public class WebSocketServerAll {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	// 클라이언트에서 send()가 실행되면 실행되는 메서드
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		synchronized (clients) {
			String id = null;
			if (message.indexOf(":[") > 0) {
				id = message.substring(message.indexOf(":[") + 2, message.indexOf("]"));
				System.out.println("id:[" + id + "]");
				String movemessage = session.getId() + " : " + message;
				for (Session client : clients) {
					if (!client.equals(session)) {		// 자기자신한테는 전송 X
						if (id == null) {
							client.getBasicRemote().sendText(movemessage);
						} else if (id.equals(client.getId())) {		// 귓속말
							client.getBasicRemote().sendText(movemessage);
						}
					}
				}
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
}
