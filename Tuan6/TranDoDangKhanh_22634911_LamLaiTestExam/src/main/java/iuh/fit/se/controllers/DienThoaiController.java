package iuh.fit.se.controllers;


import iuh.fit.se.daos.DienThoaiDAO;
import iuh.fit.se.daos.impls.DienThoaiDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "dienthoaicontroller",  urlPatterns = {"/dienthoai", "/dienthoai*"})
public class DienThoaiController extends HttpServlet {
    @Resource(name = "jdbc/lab5")
    private DataSource dataSource;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dienThoaiDAO = new DienThoaiDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dienthoai", dienThoaiDAO.findAll());
        req.getRequestDispatcher("views/dienthoai/index.jsp").forward(req,resp);
    }
}
