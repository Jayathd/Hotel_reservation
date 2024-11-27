package Feedpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedSaveServlet")
public class FeedSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String message = request.getParameter("message");

		Feed e = new Feed();

		e.setName(name);
		e.setEmail(email);
		e.setPhonenumber(phonenumber);
		e.setMessage(message);

		int status = FeedDao.save(e);
		if (status > 0) {
			response.sendRedirect("FeedViewServlet");
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("feedback.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
