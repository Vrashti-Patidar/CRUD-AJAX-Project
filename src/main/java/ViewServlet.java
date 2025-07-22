

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Employee List</title>");
		out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		
		out.print("</head>");
		out.print("<body>");
		out.print("<div class='container mt-5'>");


		List<Emp> list = EmpDao.getAllEmployee();

		out.print("<table class='table table-bordered table-hover table-striped'>");
		out.print("<thead class='table-dark'><tr>");
		out.print("<th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>");
		out.print("</tr></thead>");
		out.print("<tbody>");

		for (Emp e : list) {
		    out.print("<tr>");
		    out.print("<td>" + e.getID() + "</td>");
		    out.print("<td>" + e.getName() + "</td>");
		    out.print("<td>" + e.getPassword() + "</td>");
		    out.print("<td>" + e.getEmail() + "</td>");
		    out.print("<td>" + e.getCountry() + "</td>");
		    out.print("<td><button class='btn btn-sm btn-warning' onclick='editData(" + e.getID() + ");'>Edit</button></td>");
		    out.print("<td><button class='btn btn-sm btn-danger' onclick='deleteData(" + e.getID() + ");'>Delete</button></td>");
		    out.print("</tr>");
		}

		out.print("</tbody>");
		out.print("</table>");

		out.print("<script src='display.js'></script>");

		out.print("</div>"); 
		out.print("</body>");
		out.print("</html>");

		out.close();
		
	}

}
