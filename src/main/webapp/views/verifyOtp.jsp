<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xác Thực OTP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
<div class="login-container">
    <h2>Nhập Mã OTP</h2>

    <c:if test="${alert != null}">
        <h3 class="alert">${alert}</h3>
    </c:if>

    <form action="${pageContext.request.contextPath}/verifyOtp" method="post">
        <div class="input-group">
            <input type="text" placeholder="Nhập mã OTP" name="otp" required>
        </div>

        <button type="submit" class="btn-login">Xác nhận</button>
    </form>
</div>
</body>
</html>
