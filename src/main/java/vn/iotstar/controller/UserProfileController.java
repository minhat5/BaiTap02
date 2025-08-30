package vn.iotstar.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.service.UserService;

import java.io.IOException;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet(urlPatterns = { "/profile" })
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		User account = (User) session.getAttribute("account");

		User fresh = account;
		try {
			User u = userService.get(account.getUserName());
			if (u != null)
				fresh = u;
		} catch (Exception ignore) {
		}

		req.setAttribute("user", fresh);
		RequestDispatcher rd = req.getRequestDispatcher("/views/profile.jsp");
		rd.forward(req, resp);
	}

}
