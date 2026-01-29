package cookiess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class NewCookie extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		Cookie ck[]=req.getCookies();
		for(int i=0;i<ck.length;i++) {
			out.print("<h1>Welcome "+ck[i].getValue()+"</h1>");
		}
	}
}
