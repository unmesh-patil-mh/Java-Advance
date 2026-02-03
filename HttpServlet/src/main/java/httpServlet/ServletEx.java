package httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class ServletEx extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		try {
			int n1=Integer.parseInt(req.getParameter("n1"));
			int n2=Integer.parseInt(req.getParameter("n2"));
			int sum=n1+n2;
			out.print("<h1>Addition of Number is "+sum+"</h1>");
		}catch(NumberFormatException e) {
			out.print("<h1>Invalid input! Please provide integers.</h1>");
		}
	}
	

}
