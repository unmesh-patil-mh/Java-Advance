package cookiess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class CookieEx extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("naam");
		out.print("<h1>Hello "+name+"</h1>");
		Cookie ck=new Cookie("naam",name);
		ck.setPath("/");
		res.addCookie(ck);
		out.print("<form action='Servlet3' method='post'>");
		out.print("<button type='submit'>Submit</button>");
		out.print("</form>");
	}
}
