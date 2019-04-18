<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rbeyz68rf5&submodules=geocoder">
	
</script>
<script>
	$(function() {
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
		/*
		naver.maps.Event.addListener(map, 'click', function(e) {
			console.log(e);
			var marker = new naver.maps.Marker({
				position: new naver.maps.LatLng(e.coord),
				map : map
			});
			
			setTimeout(function() {
				marker.setMap(null);
			}, 2000);
		});

		var markerIcon = {
				url : '${contextPath}/resources/images/comde.jpg',
				size : new naver.maps.Size(32,32),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(16, 32)
		};*/
			
		var cityhall = new naver.maps.LatLng(37.5666805, 126.9784147);
		var map = new naver.maps.Map('map', {
			center: new naver.maps.LatLng(37.5698411, 126.9783927),
			zoom: 10
		});
		var marker = new naver.maps.Marker({
			map: map,
			position: cityhall
		});
		
		contentString = `
				<div><img src='http://localhost:8080/monitor/camera/1' width="320"></div>
				<span>서울 시청입니다</span>				
			`;
			
		var infowindow = new naver.maps.InfoWindow({
			content: contentString
		});
		
		naver.maps.Event.addListener(marker, "click", function(e) {
			if (infowindow.getMap()) {
				infowindow.close();
			} else {
				infowindow.open(map, marker);
		}
		});		
		
	});
</script>

<body>
	<div id="map" style="width: 100%; height: 400px;"></div>
</body>
</html>