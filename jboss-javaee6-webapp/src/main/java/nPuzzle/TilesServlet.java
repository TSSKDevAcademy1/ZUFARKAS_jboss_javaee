package nPuzzle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/kamene")
public class TilesServlet extends HttpServlet {

	private static final String FIELD_ATTRIBUTE = "field";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tiles serwlet</title>");
		out.println("</head>");
		out.println("<body>");
		
		HttpSession session = req.getSession();
		Field field = (Field) session.getAttribute(FIELD_ATTRIBUTE);

		if (field == null) {
			field = newGame(session);
		} else {
			try {
				String row = req.getParameter("row");
				String column = req.getParameter("column");
				field.move(Integer.parseInt(row), Integer.parseInt(column));
			} catch (Exception e) {
				e.printStackTrace();
			}

			String command = req.getParameter("command");
			if (command != null) {
				field = newGame(session);
			}

		}

		// prints the tiles field
		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				out.printf("<a href='?row=%s&column=%s'><img src='resources/images2/" + field.getTile(row, column)
						+ ".png'></a>", row, column);
			}
			out.println("<br>");
		}

		out.print("<a href='?command=new'>New game</a>");

		out.println("<br>");
		
		if (field.isSolved()) {
			out.println("<span style='color:#000099'><strong>Congratulation! You won.</strong></span>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	private Field newGame(HttpSession session) {
		Field field = new Field(4, 4);
		session.setAttribute(FIELD_ATTRIBUTE, field);
		return field;
	}
}
