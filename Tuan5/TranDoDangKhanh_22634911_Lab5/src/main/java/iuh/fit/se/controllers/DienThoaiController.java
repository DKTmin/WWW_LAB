package iuh.fit.se.controllers;


import iuh.fit.se.daos.DienThoaiDAO;
import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.daos.impls.DienThoaiDAOImpl;
import iuh.fit.se.daos.impls.NhaCungCapDAOImpl;
import iuh.fit.se.entities.DienThoai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dienthoaiController", urlPatterns = {"/dienthoai", "/dienthoai*"})
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "listByNCC":
                listByNCC(request, response);
                break;
            case "list":
            default:
                listAll(request, response);
                break;
        }
    }

    private void listByNCC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maNCC = request.getParameter("id");
        List<DienThoai> list = dienThoaiDAO.findByNhaCungCap(maNCC);
        request.setAttribute("dienthoais", list);
        request.getRequestDispatcher("/views/dienthoai/index.jsp").forward(request, response);
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DienThoai> list = dienThoaiDAO.findAll();
        request.setAttribute("dienthoais", list);
        request.getRequestDispatcher("/views/dienthoai/index.jsp").forward(request, response);
    }
}
