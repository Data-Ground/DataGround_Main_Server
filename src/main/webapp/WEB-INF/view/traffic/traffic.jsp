<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a9c7154dea68673377664fd3c241c42a"></script>
<script src="/DataGround/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	
	var container = document.getElementById('map'); 
	var options = { 
		center: new daum.maps.Coords(211393 * 2.5, 450479 * 2.5),
		level: 3
	};
	var map = new daum.maps.Map(container, options); 
	map.addOverlayMapTypeId(daum.maps.MapTypeId.TRAFFIC);
	
	// 마커가 표시될 위치와 내용을 가지고 있는 객체 배열
	var positions = [
		{
			content: '<div>올림픽로(신한은행암사지점→선사사거리)2차로공사</div>',
			Coords: new daum.maps.Coords(211393 * 2.5, 450479 * 2.5)
		}
	];
	
	for(var i = 0; i<positions.length; i++) {
		//마커를 생성
		var marker = new daum.maps.Marker({
			map: map, //마커를 표시할 지도
			position: positions[i].Coords // 마커 위치
		});
		
		// 마커에 표시할 인포윈도우를 생성
		  var infowindow = new daum.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });
		// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	}
	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}

	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	// 마커가 지도 위에 표시되도록 설정
	marker.setMap(map);
	
})
</script>

	<div id="map" style="width: 500px; height: 400px;">

<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />