package edu.autocar.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import edu.autocar.domain.CarMessage;

public class CarHandler extends TextWebSocketHandler {
	Map<Integer, List<WebSocketSession>> map = Collections.synchronizedMap(new HashMap<>());

	// 접속 성공시 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Car 핸들러에 접속하셨음");
	}
		
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String rcvMsg = message.getPayload();
		System.out.println("클라이언트에게 받은 데이터 : " + rcvMsg);
		Gson gson = new Gson();
		CarMessage carMsg = gson.fromJson(rcvMsg, CarMessage.class);
		System.out.println("JSON -> 객체 : " + carMsg);
		
		int target = carMsg.getTarget();
		System.out.println(session);
		
		if (carMsg.getMsgType().contentEquals("POSITION_SUB")) {
			System.out.println("옵저버 등록합니다 " + session);
			addObserver(target, session);
		} else if (carMsg.getMsgType().equals("POSITION")) {
			List<WebSocketSession> list = map.get(target);
			
			if (list != null) {
				for (WebSocketSession s : list) {
					if (s != session)
						s.sendMessage(message);
				}
			}
		} else if(carMsg.getMsgType().equals("CONTROL")) {
			
		} else if(carMsg.getMsgType().equals("CONTROL_SUB")) {
			
		}
	}

	private void addObserver(int target, WebSocketSession session) {
		List<WebSocketSession> list = map.get(target);

		if (list == null) {
			list = new LinkedList<>();
			map.put(target, list);
		}
		list.add(session);
	}

	// 접속 해제시 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("연결을 종료합니다.");
		for (int target : map.keySet()) {
			List<WebSocketSession> list = map.get(target);
			System.out.println("삭제될 세션 : " + session);
			if (list.remove(session)) {
				break;
			}
		}
	}
}
