package minesweeperZuzka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minesweeper2")
public class Minesweeper2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
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

		for (int row = 0; row < field.getRowCount(); row++) {
			out.println("<br>");
			for (int column = 0; column < field.getColumnCount(); column++) {
				out.printf("<a href='?row=%s&?column=%s'><img src='resources/gfx/images/closed.png'></a>", row, column);
			}
		}

		out.println("</body>");

	}

	private void printTile(PrintWriter out, int row, int column, String image) {
		// out.printf("<a href=\"?row=%s&column=%s\"><img
		// src=\"resources/gfx/images/%s.png\"></a>", row, column, image);
		out.printf("<a href='?row=%s&column =%s'><img src='resources/gfx/images/%s.png'></a>", row, column, image);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	// private Settings setting = getSetting();
	//
	// public Settings getSetting() {
	// return setting;
	// }
	//
	// public void setSetting(Settings setting) throws
	// UnsupportedEncodingException, FileNotFoundException, IOException {
	// {
	// this.setting = setting;
	// this.setting.save();
	// }
	// }
	//
	// private static Minesweeper instance;
	//
	//
	// public static Minesweeper getInstance() {
	// if ( instance == null )
	// {
	// new Minesweeper();
	// }
	// return instance;
	// }
	//
	// public BestTimes getBestTimes() {
	// return bestTimes;
	// }
	//
	// /**
	// * Constructor.
	// */
	// private Minesweeper() {
	// instance = this;
	// userInterface = new ConsoleUI();
	//
	// Field field = new Field(2, 2, 2);
	// // System.out.println(field);
	// userInterface.newGameStarted(field);
	// }
	//
	// public int getPlayingSeconds() {
	// long endTime = System.currentTimeMillis();
	// return (int) ((endTime - startMillis) / 1000);
	// }
	//
	//
	//
	// public void newGame() {
	// Field field = new Field(setting.getRowCount(), setting.getColumnCount(),
	// setting.getMineCount());
	// startMillis = System.currentTimeMillis();
	// userInterface.newGameStarted(field);
	// }

}
