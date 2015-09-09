package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello3")
public class HelloWorldServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String meno;
	String pass;
	String age;
	String country;
	String messageName = "";
	String messagePass = "";
	String messageAge = "";

	//na skusanie niecoho
	public HelloWorldServlet3() {
		System.out.println("////////////////////////////////////////////////////////////");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src=\"resources/gfx/wildfly_400x130.jpg\"><br>");
		verifyNameAndPass(request, response);
		out.println(new Date());
		out.println("</body>");
		out.println("</html>");
	}

	public void verifyNameAndPass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		meno = request.getParameter("meno");
		pass = request.getParameter("pass");
		age = request.getParameter("age");
		country = request.getParameter("country");

		if (meno == null) {
			meno = "";
		}
		if (pass == null) {
			pass = "";
		}
		if (age == null) {
			age = "";
		}
		if (meno.length() < 5 || meno.length() > 10 || "".equals(meno)) {
			messageName = "Zadaj meno o dlzke 5-10 znakov.";
		} else
			messageName = "";
		if (pass.length() < 5 || pass.length() > 10 || "".equals(pass)) {
			messagePass = "Zadaj heslo o dlzke 5-10 znakov s minimalne jednou cislicou.";
		} else {
			Pattern p = Pattern.compile(".*[0-9].*");
			Matcher matcher = p.matcher(pass);
			if (matcher.matches()) {
				messagePass = "";
			}
		}
		if ("".equals(age)) {
			messageAge = "Zadaj vek od 1-150 rokov.";
		} else
			messageAge = "";
		if (meno.length() > 4 && meno.length() < 11 && pass.length() > 4 && pass.length() < 11 && "".equals(messagePass)
				&& !"".equals(age) && country != null) {
			out.printf("<h1>Vitaj %s%n</h1>", meno + ", tvoj vek je: " + age + " a krajina " + country);
		} else {
			form(out, request, response);
		}
	}

	void form(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws IOException {
		out.println("<h1>Hello world</h1>");
		out.println("<form method=\"post\">");
		out.println("Name: <input type=\"text\" name=\"meno\" value=\"" + meno + "\">");
		out.println(messageName + "<br>");
		out.println("Password: <input type=\"password\" name=\"pass\" value=\"" + pass + "\">");
		out.println(messagePass + "<br>");
		out.println("Age: <input type=\"number\" name=\"age\" min=\"1\" max=\"150\" value=\"" + age + "\">");
		out.println(messageAge + "<br>");
		Countries(request, response);
		out.println("<input type=\"submit\" value=\"Send\">");
		out.println("</form>");
	}

	// premenovat na sloveso
	public void Countries(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String[] locales = Locale.getISOCountries();
		out.println("Country: <select name=\"country\">");
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			out.println("<option value=\"" + obj.getDisplayCountry() + "\">" + obj.getDisplayCountry() + "</option>");
		}
		out.println("Country: </select><br>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
