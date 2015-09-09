package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello vilag</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello world</h1>");
		// out.println(new Date());

		out.printf("<h1>Hello world %s\n</h1>", request.getParameter("meno"));
		request.getParameter("name");

		out.printf("<img src=\"resources/gfx/wildfly_400x130.jpg\" />");

		out.println("<form action =\"hello\" method = \"post\">");
		// The action attribute specifies where to send the form-data when a
		// form is submitted.
		out.println("Name: <input type=\"text\" name = \"meno\"><br>");
		out.println("Password: <input type=\"password\" name = \"heslo\"><br>");
		out.println(" <input type=\"submit\" value = \"Send!\">");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doGet(req, resp);
	}
}
