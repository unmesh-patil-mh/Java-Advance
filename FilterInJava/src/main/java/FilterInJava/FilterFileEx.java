package FilterInJava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Servlet")
public class FilterFileEx implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out=res.getWriter();
		String pass=req.getParameter("pass");
		if(pass.equals("admin")) {
			chain.doFilter(req, res);
		}
		else {
			out.print("<br>Invalid Password");
		}
	}
}
