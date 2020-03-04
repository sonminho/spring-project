<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rbeyz68rf5&submodules=geocoder">
	
</script>
<script>
	$(function() {
		if (!window.WebSocket) {
			alert('웹 소켓을 지원하지 않는 브라우저 입니다.');
			return;
		}
		var mapOptions = {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10, // 1(최소)~14(최대), 기본 : 11
			scaleControl : false,
			logoControl : false,
			mapDataControl : false,
			zoomControl : true,
			zoomControlOptions : {
				style : naver.maps.ZoomControlStyle.SMALL
			}
		};		
		var map = new naver.maps.Map('map', mapOptions);

		var carMarker = new naver.maps.Marker({
			map : map,
			position : new naver.maps.LatLng(37.3595704, 127.105399),
		});
		
		var socket = new WebSocket("ws://localhost:8080/monitor/car");
		socket.onopen = function() {
			console.log('접속 성공');

			msg = JSON.stringify({
				msgType : 'POSITION_SUB',
				target : '1',
			});
			
			socket.send(msg);
		}

		socket.onmessage = function(msg) {
			carMsg = JSON.parse(msg.data)
			console.log('데이터 수신 : ', carMsg);
			
			if (carMsg.msgType == "POSITION") {
				position = new naver.maps.LatLng(carMsg.lat, carMsg.lng);
				console.log('마커 위치를 변경 : ', carMsg.lat, carMsg.lng);
				map.setCenter(position);
				carMarker.setPosition(position);
			}

			$('#recv-message').text(msg.data);
		}

		socket.onclose = function() {
			console.log('접속 해제');
		}

		socket.onerror = function(err) {
			console.log('에러 ', err);
		}
		
		$('#send-btn').click(function() {
			var msg = $('#send-message').val();
			var lat = $('#send-lat').val();
			var lng = $('#send-lng').val();
			
			msg = JSON.stringify({
				msgType : 'POSITION',
				target : '1',
				lat : lat,
				lng : lng
			});
						
			socket.send(msg);
		})
		
		$('.direction').click(function() {
			direction = $(this).data('direction');
			msg = JSON.stringify({
				msgType:'CONTROL',
				target:'1',
				direction:direction
			});
			socket.send(msg)
		});
		
	});
</script>
</head>
<body>
	<h1>웹 소켓 테스트</h1>
	<div> 
		위도 : <input type="text" id="send-lat">
		경도 : <input type="text" id="send-lng">
		<button type="button" id="send-btn">위치전송</button>
	</div>
	<div>
		수신 메시지 : <span id="recv-message"></span>
	</div>
	<div id="map" style="width: 100%; height: 400px;"></div>
</body>
</html>