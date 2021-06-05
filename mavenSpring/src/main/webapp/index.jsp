<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<h2>Hello World!</h2>

<span>로그인 페이지로 이동 : </span>
	<a href="/customLogin">로그인</a>
	<br>
	<span>게시판 페이지로 이동 : </span> 
	<a href="/board/list">게시판</a>
	<br>
	
<sec:authorize access="isAnonymous()">	
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/customLogout">로그아웃</a>
</sec:authorize>

</body>
</html>
