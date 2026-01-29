package urlRewrting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		String name=req.getParameter("username");
		out.print("<h1>Welcome "+name+"</h1>");
	}
}
