package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hellozuzka")
public class HelloZuzka extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meno = req.getParameter("meno");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.print("<head>");
		out.print("<title> Ahoj Svet</title>");
		out.print("</head>");
		out.print("<body>");

		// meno="";
		if (isValidName(meno)) {
			out.printf("<h1>Hello %s</h1>", meno);
		} else {
			meno = "";
			out.println("<form action =\"hellozuzka\" method = \"post\">");
			out.println("Name: <input type='text' name = 'meno' value = '" + meno + "'>" + " Please, enter the name");
			out.println("<br>");
			out.println("<input type='submit' value = 'Send!'>");

			out.println("</form>");
		}
		

		out.print("</body>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private boolean isValidName(String s) {

		if (s == null || s.equals("") || s.length() > 10 || s.length() < 5) {
			return false;
		}

		return true;
	}

	// private boolean isValidPassword(String s) {
	//
	// if (s == null || s.equals("") || s.length() > 10 || s.length() < 5) {
	// return false;
	// }
	// int len = s.length();
	// for (int i = 0; i < len; i++) {
	//
	// if (Character.isDigit(s.charAt(i))) {
	// return true;
	// }
	// }
	//
	// return false;
	// }
	//
	// private boolean isValidAge(String ages) {
	// try {
	// int age = Integer.parseInt(ages);
	// return age > 0 & age < 151;
	// } catch (NumberFormatException e) {
	// return false;
	// }
	// }
}
