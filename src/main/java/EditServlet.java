

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		Emp e=EmpDao.getEmployeeById(id);
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Edit Employee</title>");
		out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class='container mt-5'>");
		out.print("<h2 class='mb-4 text-primary'>Edit Employee</h2>");

		out.print("<form>");
		out.print("<input type='hidden' name='id' value='" + e.getID() + "'>");
		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Name:</label>");
		out.print("<input type='text' class='form-control' name='name' id='1name' value='" + e.getName() + "'>");
		out.print("</div>");
		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Password:</label>");
		out.print("<input type='password' class='form-control' name='password' id='1pass' value='" + e.getPassword() + "'>");
		out.print("</div>");
		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Email:</label>");
		out.print("<input type='email' class='form-control' name='email' id='1email' value='" + e.getEmail() + "'>");
		out.print("</div>");
		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Country:</label>");
		out.print("<select class='form-select' name='country' id='1country'>");
		String[] countries = {"india", "usa", "uk", "other"};
		for (String country : countries) {
		    String selected = country.equalsIgnoreCase(e.getCountry()) ? "selected" : "";
		    out.print("<option value='" + country + "' " + selected + ">" + country.toUpperCase() + "</option>");
		}
		out.print("</select>");
		out.print("</div>");
		out.print("<button type='button' class='btn btn-success' onclick='editData2(" + e.getID() + ")'>Edit & Save</button>");
		out.print("</form>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
