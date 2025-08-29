package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.util.EmailUtility;

import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/forgetpassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String alertMsg = "";

		UserServiceImpl service = new UserServiceImpl();
		User user = service.getUserByEmail(email);

		if (user != null) {
			// Sinh mã OTP 6 số
			Random random = new Random();
			int otp = 100000 + random.nextInt(900000);

			HttpSession session = request.getSession();
			session.setAttribute("otp", otp);
			session.setAttribute("otpEmail", email);
			session.setAttribute("otpExpireTime", System.currentTimeMillis() + 5 * 60 * 1000);

			try {
				// Gửi email OTP
				String subject = "Mã OTP xác nhận đặt lại mật khẩu";
				String message = "Xin chào " + user.getUserName() + ",\n\n" + "Mã OTP của bạn là: " + otp + "\n"
						+ "Mã này sẽ hết hạn sau 5 phút.\n\n"
						+ "Nếu không phải bạn yêu cầu, vui lòng bỏ qua email này.";

				EmailUtility.sendEmail("smtp.gmail.com", "587", "nguyennhatminh0514@gmail.com", "roqa xsgc ktsz vewl",
						email, subject, message);

				response.sendRedirect(request.getContextPath() + "/views/verifyOtp.jsp");

			} catch (Exception e) {
				e.printStackTrace();
				alertMsg = "Không thể gửi email OTP. Vui lòng thử lại.";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/forgetpassword.jsp").forward(request, response);
			}
		} else {
			alertMsg = "Email không tồn tại trong hệ thống.";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forgetpassword.jsp").forward(request, response);
		}
	}
}
