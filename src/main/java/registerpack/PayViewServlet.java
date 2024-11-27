package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayViewServlet")
public class PayViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Start HTML structure and define some CSS styles
		out.print("<html><head><title>Payment Details</title>");
		out.print("<style>");
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
		out.print("h1 {");
		out.print("  color: white;");
		out.print("  font-size: 2.5em;");
		out.print("  margin-top: 20px;");
		out.print("}");
		out.print("a {");
		out.print("  text-decoration: none;");
		out.print("  color: #007BFF;");
		out.print("  margin: 10px;");
		out.print("  font-size: 1.2em;");
		out.print("}");
		out.print(".table-container {");
		out.print("  margin: 50px auto;");
		out.print("  width: 80%;");
		out.print("  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
		out.print("}");
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
		out.print("<div class=\"backGround\"></div>");

		// Create page header
		out.println("<h1>Payment Details</h1>");
		
		// Table container for a neat layout
		out.print("<div class='table-container'>");

		// Retrieve a list of payment records from the database
		List<PayEmp> list = PayEmpDao.getAllEmployees();

		// Generate an HTML table to display the payment details
		out.print("<table>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Passport ID</th><th>Card Name</th><th>Card Number</th><th>Amount</th><th>Edit</th><th>Delete</th></tr>");
		for (PayEmp e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPassportid() + "</td><td>" + e.getCardname() + "</td><td>" + e.getCardnumber() + "</td><td>"
					+ e.getAmount() + "</td><td><a href='PayEditServlet?id=" + e.getId() + "' class='edit'>Edit</a></td><td><a href='PayDeleteServlet?id=" + e.getId() + "' class='delete'>Delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("</div>");

		// Close HTML structure
		out.print("</body></html>");
		out.close();
	}
}
