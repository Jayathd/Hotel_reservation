package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get email and password from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Initialize response object
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Establish a database connection
            Connection con = RegDao.getConnection();

            // Prepare SQL query to check if user exists and credentials match
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reguser WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            // If user found, redirect to the user account page
            if (rs.next()) {
                // Store user info in session
                HttpSession session = request.getSession();
                session.setAttribute("userEmail", email);
                session.setAttribute("userName", rs.getString("fristname"));

                // Redirect to a welcome page or account page
                response.sendRedirect("home.html");
            } else {
                // If login fails, display error message
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid email or password. Please try again.');");
                out.println("location='login.html';");
                out.println("</script>");
            }

            // Close the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
