<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="cxt" value="${pageContext.request.contextPath}" />

<header class="topbar">
	<div class="topbar__left">
		<a class="logo" href="${cxt}/">MyApp</a>
		<nav>
			<ul class="main-nav">
				<li><a href="${cxt}/">Trang chủ</a></li>
				<!-- Hiện khi đã đăng nhập -->
				<c:if test="${sessionScope.account != null}">
					<li><a href="${cxt}/home">Home</a></li>
				</c:if>

				<!-- Chỉ hiện với Admin -->
				<c:if
					test="${sessionScope.account != null && sessionScope.account.roleid == 2}">
					<li><a href="${cxt}/admin/category/list">Quản trị viên</a></li>
				</c:if>

				<!-- Nếu có vai trò Manager -->
				<c:if
					test="${sessionScope.account != null && sessionScope.account.roleid == 3}">
					<li><a href="${cxt}/manager/home">Quản lý</a></li>
				</c:if>
			</ul>
		</nav>
	</div>

	<div class="topbar__right">
		<c:choose>
			<c:when test="${sessionScope.account == null}">
				<ul class="auth-links">
					<li><a href="${cxt}/login">Đăng nhập</a></li>
					<li><a href="${cxt}/register">Đăng ký</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="auth-links">
					<li><a href="${cxt}/profile" title="Trang cá nhân">
							${sessionScope.account.fullName} </a></li>
					<li><a href="${cxt}/logout">Đăng xuất</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</header>
