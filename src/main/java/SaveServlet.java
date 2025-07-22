

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("ename");
		String pass=request.getParameter("epass");
		String email=request.getParameter("eemail");
		String country=request.getParameter("ecountry");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(pass);
		e.setEmail(email);
		e.setCountry(country);
		
		int status=EmpDao.save(e);
		
		out.print("<!DOCTYPE HTML>");
		out.print("<html>");
		out.print("<head>");
		out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class='container mt-5'>");
		if(status>0) {
			out.print("<div class='alert alert-success' role='alert'>");
		    out.print("✅ Record saved successfully!");
		    out.print("</div>");
			
		}
		else {
			out.print("<div class='alert alert-danger' role='alert'>");
		    out.print("❌ Sorry, unable to save record.");
		    out.print("</div>");
		}
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

}
