package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.constant.Constant;

import java.io.IOException;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null)
			session.invalidate();

		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, "");
		cookie.setMaxAge(0);
		cookie.setPath(req.getContextPath());
		resp.addCookie(cookie);

		resp.sendRedirect(req.getContextPath() + "/login");
	}

}
