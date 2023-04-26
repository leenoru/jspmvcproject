<%@ page pageEncoding="UTF-8" language="java" %>

<header>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary ">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="/index">🎮Play.GG</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-sm-center bi bi-battery-full" aria-current="page" href="/login"> 로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">회원가입</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
    <nav>
        <ul>
            <li>Board</li>

            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    <li>${sessionScope.username}님 환영합니다.</li>
                    <li><a href="logout">로그아웃</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login">로그인</li>
                    <li><a href="register">회원가입</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>