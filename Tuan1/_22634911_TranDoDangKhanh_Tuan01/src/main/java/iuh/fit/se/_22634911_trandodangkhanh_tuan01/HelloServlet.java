package iuh.fit.se._22634911_trandodangkhanh_tuan01;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet",
        initParams ={
            @WebInitParam(name = "username", value="u0001"),
                @WebInitParam(name = "email", value="u001@gmail.com"),
        })
public class HelloServlet extends HttpServlet {
    private String message;

    private String username;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        username = config.getInitParameter("username");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1 style='color:red'>" + this.getInitParameter("email") + "</h1>");
        out.println("<h3 style='color:blue'>" + username + "</h3>");
        out.println("<h3 style='color:green'>" + this.getServletContext().getInitParameter("appName") + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}