package urlRewrting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("username");
		out.print("<h1>Hii How are You "+name+"</h1>");
		out.print("<a href='Servlet2?username="+name+"'>Visit Your Site</a>");
}
}