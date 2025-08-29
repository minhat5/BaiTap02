package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/verifyOtp")
public class VerifyOtpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String inputOtp = request.getParameter("otp");
        Integer otp = (Integer) session.getAttribute("otp");
        Long expireTime = (Long) session.getAttribute("otpExpireTime");

        if (otp == null || expireTime == null) {
            request.setAttribute("alert", "OTP không hợp lệ. Vui lòng yêu cầu lại.");
            request.getRequestDispatcher("/views/verifyOtp.jsp").forward(request, response);
            return;
        }

        if (System.currentTimeMillis() > expireTime) {
            request.setAttribute("alert", "OTP đã hết hạn. Vui lòng yêu cầu lại.");
            request.getRequestDispatcher("/views/verifyOtp.jsp").forward(request, response);
            return;
        }

        if (inputOtp.equals(String.valueOf(otp))) {
            response.sendRedirect(request.getContextPath() + "/views/resetPassword.jsp");
        } else {
            request.setAttribute("alert", "OTP không đúng. Vui lòng thử lại.");
            request.getRequestDispatcher("/views/verifyOtp.jsp").forward(request, response);
        }
    }
}
