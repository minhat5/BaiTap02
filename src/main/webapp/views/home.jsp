<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="topbar.jsp" />

	<h2>Xin chào ${sessionScope.account.fullName}</h2>
	<p>Đây là trang chính của người dùng.</p>
</body>
</html>