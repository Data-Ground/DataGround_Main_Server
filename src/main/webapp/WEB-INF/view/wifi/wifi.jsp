<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9fd667b93840b26ac510c5584c6c287f"></script>
<script src="/DataGround/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new daum.maps.LatLng(37.5642135, 127.0016985), //지도의 중심좌표.
		level: 9 //지도의 레벨(확대, 축소 정도)
	};
	var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
})
</script>
<style type="text/css">
	
</style>
</head>
<body>

	<div id="map" style="width: 500px; height: 400px;">
		
	</div>

</body>
</html>