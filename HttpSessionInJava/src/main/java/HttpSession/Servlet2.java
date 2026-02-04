package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession Session=req.getSession();
		String name=Session.getAttribute("username").toString();
		out.print("<h1>Hello "+name+"</h1>");
		out.close();
	}
}
