package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.service.impl.UserServiceImpl;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/resetPassword")
public class ResetPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/resetPassword.jsp").forward(request, response);
	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("otpEmail");

        if (email == null) {
            request.setAttribute("alert", "Phiên làm việc đã hết hạn. Vui lòng thử lại.");
            request.getRequestDispatcher("/views/resetPassword.jsp").forward(request, response);
            return;
        }

        if (newPassword == null || confirmPassword == null || !newPassword.equals(confirmPassword)) {
            request.setAttribute("alert", "Mật khẩu nhập lại không khớp.");
            request.getRequestDispatcher("/views/resetPassword.jsp").forward(request, response);
            return;
        }

        UserServiceImpl service = new UserServiceImpl();
        boolean updated = service.updatePasswordByEmail(email, newPassword);

        if (updated) {
            // Xóa session OTP
            session.removeAttribute("otp");
            session.removeAttribute("otpEmail");
            session.removeAttribute("otpExpireTime");

            request.setAttribute("alert", "Đặt lại mật khẩu thành công. Vui lòng đăng nhập.");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        } else {
            request.setAttribute("alert", "Có lỗi xảy ra khi đặt lại mật khẩu.");
            request.getRequestDispatcher("/views/resetPassword.jsp").forward(request, response);
        }
    }
}
