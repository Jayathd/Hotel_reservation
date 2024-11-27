package Feedpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedEditServlet")
public class FeedEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<style>");
		// Adding background image and other styles
		out.println("body {font-family: Arial, sans-serif; background-image: url('images/background.jpg'); background-size: cover; margin: 0; padding: 20px;}");
		out.println("h1 {color: white; text-align: center;}");
		out.println("form {background-color: rgba(255, 255, 255, 0.8); padding: 20px; margin: auto; width: 50%; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);}");
		out.println("table {width: 100%;}");
		out.println("td {padding: 10px;}");
		out.println("input[type='text'], input[type='email'], input[type='password'] {width: 100%; padding: 8px; margin: 5px 0; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;}");
		out.println("input[type='submit'] {background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;}");
		out.println("input[type='submit']:hover {background-color: #45a049;}");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<h1>Update Feedback</h1>");
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Feed e = FeedDao.getEmployeeById(id);

		out.print("<form action='FeedEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='text' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Phone Number:</td><td><input type='text' name='phonenumber' value='" + e.getPhonenumber() + "'/></td></tr>");
		out.print("<tr><td>Message:</td><td><input type='text' name='message' value='" + e.getMessage() + "'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.println("</body></html>");
		out.close();
	}
}
