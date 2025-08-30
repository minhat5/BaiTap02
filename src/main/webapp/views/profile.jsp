<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Hồ sơ cá nhân</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
  <%@ include file="topbar.jsp" %>

  <div class="page">
    <div class="container">
      <div class="card profile-card">
        <div class="profile-header">
          <img class="avatar"
               src="<c:out value='${empty user.avatar ? pageContext.request.contextPath + "/images/default-avatar.png" : user.avatar}'/>"
               alt="avatar">
          <div>
            <h2>${user.fullName}</h2>
            <p>@${user.userName}</p>
          </div>
        </div>

        <div class="profile-body">
          <div class="row">
            <span class="label">Email</span>
            <span class="value">${user.email}</span>
          </div>
          <div class="row">
            <span class="label">Số điện thoại</span>
            <span class="value">${user.phone}</span>
          </div>
          <div class="row">
            <span class="label">Quyền</span>
            <span class="value">
              <c:choose>
                <c:when test="${user.roleid == 1}">Quản trị viên</c:when>
                <c:when test="${user.roleid == 2}">Quản lý</c:when>
                <c:otherwise>Người dùng</c:otherwise>
              </c:choose>
            </span>
          </div>
          <div class="row">
            <span class="label">Ngày tạo</span>
            <span class="value">
              <fmt:formatDate value="${user.createdDate}" pattern="dd/MM/yyyy HH:mm" />
            </span>
          </div>
        </div>

        <div class="profile-actions">
          <a class="btn" href="${pageContext.request.contextPath}/resetPassword">Đổi mật khẩu</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
