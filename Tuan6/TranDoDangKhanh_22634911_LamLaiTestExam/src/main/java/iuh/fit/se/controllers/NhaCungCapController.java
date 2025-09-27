package iuh.fit.se.controllers;

import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.daos.impls.NhaCungCapDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "nhacungcap", value = "/nhacungcap")
public class NhaCungCapController extends HttpServlet {
    @Resource(name = "jdbc/lab5")
    private DataSource dataSource;

    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.nhaCungCapDAO =new NhaCungCapDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("nhacungcap", nhaCungCapDAO.findAll());
            req.getRequestDispatcher("views/nhacungcap/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
