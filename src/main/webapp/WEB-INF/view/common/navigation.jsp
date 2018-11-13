<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$().ready(function() {
	$("#searchBtn").click(function() {
/* 		window.location = "/WeGo/ourgoal/list/" + $("#searchInput").val(); */
	});
});
</script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="<c:url value='/main' />" >DataGround</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor03">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">김종현─</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/wifi' />" >류복기│</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/shopping' />" >방누리┌</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">유재헌┐</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">장선웅┘</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
