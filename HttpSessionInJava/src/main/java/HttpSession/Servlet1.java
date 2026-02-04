package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("username");
		out.print("<h1>Welcome "+name+"</h1>");
		HttpSession Session=req.getSession();
		Session.setAttribute("username", name);
		out.print("<br>");
		String id=Session.getId();
		out.print(id);
		out.print("<a href='Servlet2'><br>Visit</a>");
		out.close();
	}
}
