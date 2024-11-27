package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Include Bootstrap and custom CSS styles
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<title>Update Registrations</title>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");

		out.println("<style>");
		out.println("/* Background styling */");
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

		out.println("/* Form container styling */");
		out.println(".form-container {");
		out.println("position: relative;");
		out.println("z-index: 1;");
		out.println("max-width: 600px;");
		out.println("margin: 10% auto;");
		out.println("background-color: rgba(255, 255, 255, 0.8);");
		out.println("padding: 30px;");
		out.println("border-radius: 10px;");
		out.println("box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);");
		out.println("}");

		out.println("/* Form heading */");
		out.println("h1 {");
		out.println("text-align: center;");
		out.println("margin-bottom: 20px;");
		out.println("color: #333;");
		out.println("}");

		out.println("/* Form fields */");
		out.println("label {");
		out.println("font-weight: bold;");
		out.println("color: #333;");
		out.println("}");

		out.println("input, select {");
		out.println("width: 100%;");
		out.println("padding: 10px;");
		out.println("margin-bottom: 15px;");
		out.println("border: 1px solid #ccc;");
		out.println("border-radius: 5px;");
		out.println("}");

		out.println("/* Submit button styling */");
		out.println("input[type='submit'] {");
		out.println("width: 100%;");
		out.println("background-color: #007bff;");
		out.println("color: #fff;");
		out.println("border: none;");
		out.println("padding: 10px;");
		out.println("border-radius: 5px;");
		out.println("cursor: pointer;");
		out.println("transition: background-color 0.3s ease;");
		out.println("}");

		out.println("input[type='submit']:hover {");
		out.println("background-color: #0056b3;");
		out.println("}");

		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		// Background div
		out.println("<div class='backGround'></div>");

		// Form container div
		out.println("<div class='form-container'>");
		out.println("<h1>Update Vehicle Registrations</h1>");

		// Retrieve 'id' from request and fetch booking details
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		// Retrieve the booking details by ID
		Book e = BookDao.getEmployeeById(id);

		// Form for editing booking details
		out.print("<form action='BookEditServlet2' method='post'>");
		out.print("<table>");

		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>First Name:</td><td><input type='text' name='Fname' value='" + e.getFname() + "'/></td></tr>");
		out.print("<tr><td>Last Name:</td><td><input type='text' name='Lname' value='" + e.getLname() + "'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='" + e.getAddress() + "'/></td></tr>");
		out.print("<tr><td>City:</td><td><input type='text' name='city' value='" + e.getCity() + "'/></td></tr>");
		out.print("<tr><td>Registration No:</td><td><input type='text' name='state' value='" + e.getState() + "'/></td></tr>");
		out.print("<tr><td>Postal Code:</td><td><input type='text' name='postalcode' value='" + e.getPostalcode() + "'/></td></tr>");
		out.print("<tr><td>Country:</td><td><input type='text' name='country' value='" + e.getCountry() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Phone:</td><td><input type='tel' name='phone' value='" + e.getPhone() + "'/></td></tr>");
		out.print("<tr><td>Registration Date:</td><td><input type='date' name='checkin' value='" + e.getCheckin() + "'/></td></tr>");
		out.print("<tr><td>Licsense Expiry Date:</td><td><input type='date' name='checkout' value='" + e.getCheckout() + "'/></td></tr>");
		out.print("<tr><td>Seat Count:</td><td><input type='number' name='person' value='" + e.getPerson() + "'/></td></tr>");

		// Room type select input
		out.print("<tr><td>Vehicle  type:</td><td>");
		out.print("<select name='roomtype' style='width:150px'>");
		out.print("<option value='bicycle'>Bicycle</option>");
		out.print("<option value='car'>Car</option>");
		out.print("<option value='van'>Van</option>");
		out.print("<option value='tuktuk'>Tuk tuk</option>");
		out.print("<option value='suv'>SUV</option>");
		out.print("<option value='other'>Other</option>");



		out.print("</select>");
		out.print("</td></tr>");

		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.println("</div>"); // End of form container
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
