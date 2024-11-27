package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegEditServlet")
public class RegEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Add styles for the edit page
        out.println("<html><head>");
        out.println("<title>Edit Registration</title>");
        out.println("<style>");
        out.println("body {font-family: Arial, sans-serif;}");
        out.println(".backGround {");
        out.println("background-image: url('images/background.jpg');");
        out.println("position: fixed;");
        out.println("height: 100%;");
        out.println("width: 100%;");
        out.println("top: 0;");
        out.println("left: 0;");
        out.println("background-repeat: no-repeat;");
        out.println("background-size: cover;");
        out.println("z-index: -1;");
        out.println("filter: blur(5px);");
        out.println("}");
        out.println(".form-container {");
        out.println("position: relative;");
        out.println("z-index: 1;");
        out.println("max-width: 400px;");
        out.println("margin: 10% auto;");
        out.println("background-color: rgba(255, 255, 255, 0.8);");
        out.println("padding: 30px;");
        out.println("border-radius: 10px;");
        out.println("box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);");
        out.println("}");
        out.println("h1 {text-align: center; color: #333; margin-bottom: 20px;}");
        out.println("label {font-weight: bold; color: #333;}");
        out.println("input, select {width: 100%; padding: 10px; margin-bottom: 15px;");
        out.println("border: 1px solid #ccc; border-radius: 5px;}");
        out.println("input[type='submit'] {background-color: #007bff; color: #fff; border: none;");
        out.println("padding: 10px; border-radius: 5px; cursor: pointer;");
        out.println("transition: background-color 0.3s ease;}");
        out.println("input[type='submit']:hover {background-color: #0056b3;}");
        out.println("</style>");
        out.println("</head><body>");
        
        // Background image
        out.println("<div class='backGround'></div>");

        // Form container
        out.println("<div class='form-container'>");
        out.println("<h1>Edit Registration</h1>");
        
        // Get the 'id' parameter from the request
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        // Retrieve a user's registration information based on the 'id'
        Reg e = RegDao.getEmployeeById(id);
        
        // Generate the form for editing user registration information
        out.print("<form action='RegEditServlet2' method='post'>");
        out.print("<label for='fristname'>First Name:</label>");
        out.print("<input type='hidden' name='id' value='" + e.getId() + "'/>");
        out.print("<input type='text' name='fristname' value='" + e.getFristname() + "' required/>");

        out.print("<label for='lastname'>Last Name:</label>");
        out.print("<input type='text' name='lastname' value='" + e.getLastname() + "' required/>");

        out.print("<label for='nic'>NIC:</label>");
        out.print("<input type='text' name='nic' value='" + e.getNic() + "' required/>");

        out.print("<label for='email'>Email:</label>");
        out.print("<input type='email' name='email' value='" + e.getEmail() + "' required/>");

        out.print("<label for='password'>Password:</label>");
        out.print("<input type='password' name='password' value='" + e.getPassword() + "' required/>");

        out.print("<label for='repassword'>Confirm Password:</label>");
        out.print("<input type='password' name='repassword' value='" + e.getRepassword() + "' required/>");

        out.print("<label for='phone'>Phone Number:</label>");
        out.print("<input type='tel' name='phone' value='" + e.getPhone() + "' required/>");

        out.print("<label for='dob'>Date of Birth:</label>");
        out.print("<input type='date' name='dob' value='" + e.getDob() + "' required/>");

        out.print("<label for='country'>Country:</label>");
        out.print("<select name='country' style='width:150px'>");
        out.print("<option>United States</option>");
        out.print("<option>Canada</option>");
        out.print("<option>United Kingdom</option>");
        out.print("<option>Sri Lanka</option>");
        out.print("<option>India</option>");
        out.print("</select>");

        out.print("<input type='submit' value='Edit &amp; Save '/>");
        out.print("</form>");
        out.println("</div>");

        out.println("</body></html>");
        out.close();
    }
}
