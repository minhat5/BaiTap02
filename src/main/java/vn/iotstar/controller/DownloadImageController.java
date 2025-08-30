package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.constant.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet implementation class DownloadImageController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/image") 
public class DownloadImageController extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fname = req.getParameter("fname");
        if (fname == null) { resp.setStatus(404); return; }
        File file = new File(Constant.DIR + File.separator + fname);
        if (!file.exists()) { resp.setStatus(404); return; }
        resp.setContentType("image/jpeg");
        try (ServletOutputStream os = resp.getOutputStream();
             FileInputStream is = new FileInputStream(file)) {
            is.transferTo(os);
        }
    }
}
