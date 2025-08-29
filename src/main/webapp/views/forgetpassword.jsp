<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    <!-- FontAwesome để có icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
</head>
<body>
<div class="login-container">
    <h2>Khôi Phục Mật Khẩu</h2>

    <c:if test="${alert != null}">
        <h3 class="alert">${alert}</h3>
    </c:if>

    <form action="${pageContext.request.contextPath}/forgotPassword" method="post">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
            <input type="email" placeholder="Nhập email đăng ký" name="email" required>
        </div>

        <button type="submit" class="btn-login">Gửi yêu cầu</button>
    </form>

    <p class="register-text">
        <a href="${pageContext.request.contextPath}/login">← Quay lại đăng nhập</a>
    </p>
</div>
</body>
</html>
