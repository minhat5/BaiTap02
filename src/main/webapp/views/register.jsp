<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="login-container">
            <h2>Tạo tài khoản mới</h2>

            <c:if test="${alert != null}">
                <h3 class="alert">${alert}</h3>
            </c:if>

            <!-- Tài khoản -->
            <section>
                <label for="username">Tài khoản</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" id="username" name="username" placeholder="Tài khoản" class="form-control" required>
                </div>
            </section>

            <!-- Họ tên -->
            <section>
                <label for="fullname">Họ tên</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" id="fullname" name="fullname" placeholder="Họ tên" class="form-control" required>
                </div>
            </section>

            <!-- Email -->
            <section>
                <label for="email">Email</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="email" id="email" name="email" placeholder="Nhập Email" class="form-control" required>
                </div>
            </section>

            <!-- Số điện thoại -->
            <section>
                <label for="phone">Số điện thoại</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                    <input type="tel" id="phone" name="phone" placeholder="Số điện thoại" class="form-control" required>
                </div>
            </section>

            <!-- Mật khẩu -->
            <section>
                <label for="password">Mật khẩu</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" id="password" name="password" placeholder="Mật khẩu" class="form-control" required>
                </div>
            </section>

            <!-- Nút đăng ký -->
            <button type="submit" class="btn-login">Tạo tài khoản</button>

            <!-- Đã có tài khoản -->
            <div class="register-text">
                Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </div>
        </div>
    </form>
</body>
</html>
