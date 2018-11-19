<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Seoul Wifi / Parkinglot Map</title>
<script src="/DataGround/js/jquery-3.3.1.min.js"></script>
<script src="/DataGround/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/DataGround/css/bootstrap.min.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9fd667b93840b26ac510c5584c6c287f&libraries=services,clusterer,drawing"></script>
<script type="text/javascript">
$().ready(function() {
	
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new daum.maps.LatLng(37.5642135, 127.0016985), //지도의 중심좌표.
		level: 9 //지도의 레벨(확대, 축소 정도)
	};
	var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	// 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new daum.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 9, // 클러스터 할 최소 지도 레벨img
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
	
	
	// wifi image
    var imageSrc = '/DataGround/img/wifiMarker.png'; // 마커이미지의 주소입니다    
    var imageSize = new daum.maps.Size(30, 30); // 마커이미지의 크기입니다
    var imageOption = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
    
    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption);
	
    $.post("/DataGround/wifi", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.positions).map(function(i, position) {
            return new daum.maps.Marker({
                position : new daum.maps.LatLng(position.lat, position.lng),
                image: markerImage
            });
        });
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });
    
 	// 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    daum.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
 	
 	// 사용자 실시간 위치 위도, 경도
 	var userLat;
 	var userLon;
 	
    // HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
    if (navigator.geolocation) {
        
        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(function(position) {
            
        	userLat = position.coords.latitude; // 위도
        	userLon = position.coords.longitude; // 경도
            
            var locPosition = new daum.maps.LatLng(userLat, userLon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            var message = '<div style="padding:5px;">사용자 현재 위치</div>'; // 인포윈도우에 표시될 내용입니다
            
            // 마커와 인포윈도우를 표시합니다
            displayMarker(locPosition, message);
                
           });
        
    } 
    else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
        
        var locPosition = new daum.maps.LatLng(33.450701, 126.570667);    
        var message = 'geolocation을 사용할수 없어요..';
            
        displayMarker(locPosition, message);
    }

    
    var userImageSrc = '/DataGround/img/user.png'; // 마커이미지의 주소입니다    
    var userImageSize = new daum.maps.Size(50, 40); // 마커이미지의 크기입니다
    
    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var userMarkerImage = new daum.maps.MarkerImage(userImageSrc, userImageSize, imageOption);
    
    var userMarker;
    
    // 지도에 마커와 인포윈도우를 표시하는 함수입니다
    function displayMarker(locPosition, message) {

        // 마커를 생성합니다
        userMarker = new daum.maps.Marker({  
            map: map, 
            position: locPosition,
            image: userMarkerImage
        }); 
        
        var iwContent = message, // 인포윈도우에 표시할 내용
            iwRemoveable = true;

        // 인포윈도우를 생성합니다
        var infowindow = new daum.maps.InfoWindow({
            content : iwContent,
            removable : iwRemoveable
        });
        
        // 인포윈도우를 마커위에 표시합니다 
        infowindow.open(map, userMarker);
        
        // 지도 중심좌표를 접속위치로 변경합니다
        map.setCenter(locPosition);      
    }

    // 지도 확대
    function zoomIn() {
    	map.setLevel(map.getLevel() - 1);
    }
    
    // 지도 축소
    function zoomOut() {
    	map.setLevel(map.getLevel() + 1);
    }
    
    $('#in').click(function() {
    	zoomIn();
    });
    
    $('#out').click(function() {
    	zoomOut();
    });
    
    $('#daum.maps.Marker.Area:1').children().click(function() {
    	alert("테슽트");
    })
    
    // 사용자 입력값
    var userInput;
    
    $('#userButton').click(function() {
	    userInput = $('#userInput').val();
	    alert(userLat);
	    alert(userLon);
    // 사용자 접속 위치 기준으로 사용자에게 입력받은 반경으로 원그리기
    var newpath = new daum.maps.LatLng(userLat,userLon);
        
    // 원 객체를 생성합니다
    var circle = new daum.maps.Circle({ 
        center : newpath, // 원의 중심좌표입니다
        /* radius: userInput, // 원의 반지름입니다 m 단위 이며 선 객체를 이용해서 얻어옵니다 */
        strokeWeight: 1, // 선의 두께입니다
        strokeColor: '#00a0e9', // 선의 색깔입니다
        strokeOpacity: 0.1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
        strokeStyle: 'solid', // 선의 스타일입니다
        fillColor: '#00a0e9', // 채우기 색깔입니다
        fillOpacity: 0.2  // 채우기 불투명도입니다 
    });
    
    circle.setRadius(userInput);
    
    var radius = Math.round(circle.getRadius()); // 원의 반경 정보를 얻어옵니다
    var content = getTimeHTML(radius); // 커스텀 오버레이에 표시할 반경 정보입니다 
    
    // 반경정보를 표시할 커스텀 오버레이를 생성합니다
    var radiusOverlay = new daum.maps.CustomOverlay({
        content: content, // 표시할 내용입니다 
        position: newpath, // 표시할 위치입니다. 클릭한 위치로 설정합니다
        xAnchor: 0,
        yAnchor: 0,
        zIndex: 1 
    });  

    // 원을 지도에 표시합니다
    circle.setMap(map); 
        
    // 반경 정보 커스텀 오버레이를 지도에 표시합니다
    radiusOverlay.setMap(map);
    });
    
    function getTimeHTML(distance) {

        // 도보의 시속은 평균 4km/h 이고 도보의 분속은 67m/min입니다
        var walkkTime = distance / 67 | 0;
        var walkHour = '', walkMin = '';

        // 계산한 도보 시간이 60분 보다 크면 시간으로 표시합니다
        if (walkkTime > 60) {
            walkHour = '<span class="number">' + Math.floor(walkkTime / 60) + '</span>시간 '
        }
        walkMin = '<span class="number">' + walkkTime % 60 + '</span>분'

        // 자전거의 평균 시속은 16km/h 이고 이것을 기준으로 자전거의 분속은 267m/min입니다
        var bycicleTime = distance / 227 | 0;
        var bycicleHour = '', bycicleMin = '';

        // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
        if (bycicleTime > 60) {
            bycicleHour = '<span class="number">' + Math.floor(bycicleTime / 60) + '</span>시간 '
        }
        bycicleMin = '<span class="number">' + bycicleTime % 60 + '</span>분'

        // 거리와 도보 시간, 자전거 시간을 가지고 HTML Content를 만들어 리턴합니다
        var content = '<ul class="info">';
        content += '    <li>';
        content += '        <span class="label">총거리</span><span class="number">' + distance + '</span>m';
        content += '    </li>';
        content += '    <li>';
        content += '        <span class="label">도보</span>' + walkHour + walkMin;
        content += '    </li>';
        content += '    <li>';
        content += '        <span class="label">자전거</span>' + bycicleHour + bycicleMin;
        content += '    </li>';
        content += '</ul>'

        return content;
    }
    
})
</script>
<style type="text/css">
	#map {
		position: relative;
	}
	
	#buttonGroup {
		position: absolute;
		top: 10px;
		right: 10px;
		z-index: 10;
	}
	
</style>
</head>
<body>

	<div id="map" style="width: 500px; height: 400px;">
		<div id="buttonGroup" class="btn-group-vertical" role="group" aria-label="...">
		  <button id="in" type="button" class="btn btn-default">+</button>
		  <button id="out" type="button" class="btn btn-default">-</button>
		</div>
	</div>
	<a href="/DataGround/wifi/update">지도정보 갱신</a>
	<div>
		<input id="userInput" type="number" placeholder="근방 몇 미터를  찾을 것인지 입력" />
		<input id="userButton" type="button" value="적용" />
	</div>
	<div id="wifi">
		<input type="button" class="btn btn-default" value="wifi"/>
	</div>
	<div id="parkinglot">
		<input type="button" class="btn btn-default" value="parkinglot"/>
	</div>
</body>
</html>