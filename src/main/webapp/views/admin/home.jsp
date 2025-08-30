<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
	<jsp:include page="../topbar.jsp" />
	<div class="page">
		<h2>Xin chào Admin: ${sessionScope.account.fullName}</h2>
		<p>Đây là trang quản trị dành cho admin.</p>
	</div>
</body>
</html>