package iuh.fit.se._22634911_trandodangkhanh_tuan01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String facebook = req.getParameter("facebook");
        String shortbio = req.getParameter("bio");
        String html = "<br>"
                + "<head>"
                + "<html>"
                + "<title>Result Page</title>" + "<body>"
                + "</body>"
                +"</html>";
        out.println(html);
        out.close();
    }
}
