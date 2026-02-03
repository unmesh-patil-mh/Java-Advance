package hiddenForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class HiddenFormEx extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("username");
		out.print("<h1>Hello "+name+"</h1>");
		out.print("<form action='Servlet2' method='get'>");
		out.print("<input type='hidden' name='uname' value="+name+">");
		out.print("<button type'submit'>Submit</button>");
		out.print("</form>");
//		out.print("<p>Debug: username param = " + name + "</p>");
	}
}
