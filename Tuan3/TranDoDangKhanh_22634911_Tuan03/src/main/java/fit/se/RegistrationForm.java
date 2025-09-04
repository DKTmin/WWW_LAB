package fit.se;

import fit.se.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String email = request.getParameter("txtEmail");
        String gender = request.getParameter("gender");

        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String birthdate = day + "/" + month + "/" + year;

        // Set data to Student
        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setBirthDate(birthdate);

        request.setAttribute("student", sv);
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}

