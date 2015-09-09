package minesweeperZuzka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mines555")
public class Minesweeper extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rowCount = 5;
		int columnCount = 5;
		int mineCount = 1;
		PrintWriter out = response.getWriter();
		Field field = (Field) request.getSession().getAttribute("field");

		if (field == null) {
			field = new Field(rowCount, columnCount, mineCount);
			request.getSession().setAttribute("field", field);
		}

		try {
			int row = Integer.parseInt(request.getParameter("row"));
			int column = Integer.parseInt(request.getParameter("column"));
			field.openTile(row, column);

		} catch (Exception e) {
		}

		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Minesweeper</title>");
		out.println("</head>");
		out.println("<body>");

		if (field.getState() == GameState.SOLVED) {
			out.printf("Vyhral si! <br>");
			out.printf("<a href=\"mines\">Nova hra</a> <br>");
			request.getSession().setAttribute("field", null);
		} else if (field.getState() == GameState.FAILED) {
			out.printf("Prehral si! <br>");
			out.printf("<a href=\"mines\">Nova hra</a> <br>");
			request.getSession().setAttribute("field", null);
		}

		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				Tile tile = field.getTile(row, column);
				switch (tile.getState()) {
				case CLOSED:
					printTile(out, row, column, "closed");
					break;
				case OPEN:
					if (tile instanceof Mine) {
						printTile(out, row, column, "mine");
					}
					if (tile instanceof Clue) {
						Clue clue = (Clue) tile;
						int value = clue.getValue();
						printTile(out, row, column, "open" + value);
					}
					break;
				}

			}
			out.println("<br>");
		}

		out.println("</body>");
		out.println("</html>");

	}

	private void printTile(PrintWriter out, int row, int column, String image) {
		//out.printf("<a href=\"?row=%s&column=%s\"><img src=\"resources/gfx/images/%s.png\"></a>", row, column, image);
		out.printf("<a href='?row = %s & column = %s'><img src='resources/gfx/images/%s.png'></a>", row, column, image);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
