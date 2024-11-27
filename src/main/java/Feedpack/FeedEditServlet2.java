package Feedpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedEditServlet2")
public class FeedEditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String mesages = request.getParameter("message");

		Feed e = new Feed();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setPhonenumber(phonenumber);
		e.setMessage(mesages);

		int status = FeedDao.update(e);
		if (status > 0) {
			response.sendRedirect("FeedViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
