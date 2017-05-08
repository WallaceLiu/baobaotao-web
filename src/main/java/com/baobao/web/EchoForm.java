package com.baobao.web;
/*package com.baobao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*//**
 * Servlet implementation class EchoForm
 *//*
@WebServlet("/EchoForm")
public class EchoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Enumeration flds = req.getParameterNames();

		if (!flds.hasMoreElements()) {
			out.print("<html>");
			out.print("<form method=\"POST\"" + "action=\"EchoForm\">");
			for (int i = 0; i < 10; i++)
				out.print("<b>Field" + i + "</b> " + "<input type=\"text\""
						+ " size=\"20\" name=\"Field" + i + "\" value=\"Value"
						+ i + "\"><br>");
			out.print("<INPUT TYPE=submit name=submit Value=\"Submit\"></form></html>");

		} else {

			out.print("<h1>Your form contained:</h1>");

			while (flds.hasMoreElements()) {
				String field = (String) flds.nextElement();
				String value = req.getParameter(field);
				out.print(field + " = " + value + "<br>");
			}
		}

		out.close();
	}
}
*/