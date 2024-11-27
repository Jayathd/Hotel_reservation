package Feedpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedViewServlet")
public class FeedViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Basic HTML structure
		out.println("<html><head><title>Feedback List</title>");
		
		// Inline CSS with blurred background image
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; background-image: url('images/background.jpg'); background-size: cover; background-attachment: fixed; margin: 0; padding: 0; position: relative; }");
		out.println("body::before { content: ''; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-image: inherit; background-size: cover; background-attachment: fixed; filter: blur(8px); z-index: -1; }");
		out.println("h1 { text-align: center; font-size: 36px; margin: 20px 0; color: #fff; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8); }");
		out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; background-color: rgba(255, 255, 255, 0.9); box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
		out.println("th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }");
		out.println("th { background-color: #007bff; color: white; font-weight: bold; }");
		out.println("td { background-color: #f9f9f9; color: #333; }");
		out.println("a { text-decoration: none; color: #007bff; }");
		out.println("a:hover { color: #0056b3; }");
		out.println(".action-links a { margin: 0 10px; padding: 6px 12px; background-color: #28a745; color: white; border-radius: 4px; text-decoration: none; }");
		out.println(".action-links a:hover { background-color: #218838; }");
		out.println("a.add-feedback { display: block; width: 180px; text-align: center; margin: 20px auto; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px; }");
		out.println("a.add-feedback:hover { background-color: #0056b3; }");
		out.println("</style>");
		
		out.println("</head><body>");
		
		// Link to add new feedback
		out.println("<a href='feedback.html' class='add-feedback'>Add New Feedback</a>");
		
		// Heading
		out.println("<h1>Feedback List</h1>");

		// Fetch the feedback list
		List<Feed> list = FeedDao.getAllEmployees();

		// Start of table
		out.print("<table>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Phonenumber</th><th>Message</th><th>Edit</th><th>Delete</th></tr>");
		
		// Loop through each feedback and display in the table
		for (Feed e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPhonenumber() + "</td><td>" + e.getMessage() + "</td>"
					+ "<td class='action-links'><a href='FeedEditServlet?id=" + e.getId() + "'>Edit</a></td>"
					+ "<td class='action-links'><a href='FeedDeleteServlet?id=" + e.getId() + "'>Delete</a></td></tr>");
		}
		out.print("</table>");

		// Close HTML
		out.println("</body></html>");
		out.close();
	}
}
