package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookViewServlet")
public class BookViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Start HTML structure and include CSS for styling
		out.print("<html><head><title>Hotel Reservation List</title>");
		out.print("<style>");
		
		// Common body and background styling
		out.print("body {");
		out.print("  font-family: Arial, sans-serif;");
		out.print("  background-color: #f5f5f5;");
		out.print("  text-align: center;");
		out.print("  margin: 0;");
		out.print("  padding: 0;");
		out.print("}");
		out.print(".backGround {");
		out.print("  background-image: url(\"images/background.jpg\");");
		out.print("  position: fixed;");
		out.print("  height: 100%;");
		out.print("  width: 100%;");
		out.print("  top: 0;");
		out.print("  left: 0;");
		out.print("  min-height: 100vh;");
		out.print("  background-size: cover;");
		out.print("  z-index: -1;");
		out.print("  filter: blur(4px);");
		out.print("}");
		
		// Header styles
		out.print("h1 {");
		out.print("  color: white;");
		out.print("  font-size: 2.5em;");
		out.print("  margin-top: 20px;");
		out.print("}");
		
		// Link styles
		out.print("a {");
		out.print("  text-decoration: none;");
		out.print("  color: #007BFF;");
		out.print("  margin: 10px;");
		out.print("  font-size: 1.2em;");
		out.print("}");
		
		// Table container with scrollable table if content overflows
		out.print(".table-container {");
		out.print("  margin: 50px auto;");
		out.print("  max-width: 90%;"); // Max width ensures the table doesn't go out of the screen
		out.print("  overflow-x: auto;"); // Adds horizontal scrolling if content overflows
		out.print("  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
		out.print("}");
		
		// Table and table styles
		out.print("table {");
		out.print("  width: 100%;");
		out.print("  border-collapse: collapse;");
		out.print("  background-color: #fff;");
		out.print("  border-radius: 10px;");
		out.print("  overflow: hidden;");
		out.print("}");
		out.print("th, td {");
		out.print("  padding: 15px;");
		out.print("  text-align: center;");
		out.print("  border-bottom: 1px solid #ddd;");
		out.print("}");
		out.print("th {");
		out.print("  background-color: #007BFF;");
		out.print("  color: white;");
		out.print("  font-size: 1.2em;");
		out.print("}");
		out.print("tr:nth-child(even) {");
		out.print("  background-color: #f2f2f2;");
		out.print("}");
		out.print("tr:hover {");
		out.print("  background-color: #f0f0f0;");
		out.print("}");
		
		// Button styles for edit/delete actions
		out.print(".edit, .delete {");
		out.print("  color: white;");
		out.print("  padding: 5px 10px;");
		out.print("  border-radius: 5px;");
		out.print("}");
		out.print(".edit {");
		out.print("  background-color: #28a745;");
		out.print("}");
		out.print(".delete {");
		out.print("  background-color: #dc3545;");
		out.print("}");
		out.print(".edit:hover {");
		out.print("  background-color: #218838;");
		out.print("}");
		out.print(".delete:hover {");
		out.print("  background-color: #c82333;");
		out.print("}");
		
		out.print("</style>");
		out.print("</head><body>");
		out.print("<div class=\"backGround\"></div>"); // Background image
		
		// Navigation and header
		out.println("<a href='book.html'>Bookings</a>");
		out.println("<h1>Hotel Reservation List</h1>");
		
		// Table container
		out.print("<div class='table-container'>");

		// Fetch booking list from BookDao
		List<Book> list = BookDao.getAllEmployees();

		// Display data in a table
		out.print(
			"<table>" +
			"<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>Registration No</th><th>Postal Code</th><th>Country</th><th>Email</th><th>Phone</th><th>Checking Date</th><th>check out date</th><th>Guest Count</th><th>Room Type</th><th>Edit</th><th>Delete</th></tr>"
		);
		for (Book e : list) {
			out.print(
				"<tr><td>" + e.getId() + "</td><td>" + e.getFname() + "</td><td>" + e.getLname() + "</td><td>" 
				+ e.getAddress() + "</td><td>" + e.getCity() + "</td><td>" + e.getState() + "</td><td>" 
				+ e.getPostalcode() + "</td><td>" + e.getCountry() + "</td><td>" + e.getEmail() + "</td><td>" 
				+ e.getPhone() + "</td><td>" + e.getCheckin() + "</td><td>" + e.getCheckout() + "</td><td>" 
				+ e.getPerson() + "</td><td>" + e.getRoomtype() + "</td><td><a href='BookEditServlet?id=" 
				+ e.getId() + "' class='edit'>Edit</a></td><td><a href='BookDeleteServlet?id=" + e.getId() 
				+ "' class='delete'>Delete</a></td></tr>"
			);
		}
		out.print("</table>");
		out.print("</div>");

		// Close HTML structure
		out.print("</body></html>");
		out.close();
	}
}
