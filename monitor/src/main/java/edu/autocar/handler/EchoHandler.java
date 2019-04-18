package edu.autocar.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	List<WebSocketSession> list = new ArrayList<>();
	
	/*
	  메세지 정의
		  {
			  msgType :  "POSITION" / "CONTROL"
			  target :
			  lat :
			  lng :
			  .
			  .
			  .
		  }
	 */
	
	// 접속 성공시 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("접속하셨음");
		list.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String rcvMsg = message.getPayload();
		TextMessage sendMsg = new TextMessage(rcvMsg);
		//session.sendMessage(sendMsg);
		
		for(WebSocketSession ws : list) {
			if(ws != session) {
				ws.sendMessage(sendMsg);
			}
		}
	}
	
	// 접속 해제시 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		list.clear();
	}
}
