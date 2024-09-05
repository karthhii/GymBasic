package mini;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class PrintPlans
 */
public class PrintPlans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintPlans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
	    pw.println("<html><body>");
	    
        pw.println("<h2>Table Data</h2>");
        pw.println("<style>");
        pw.println("table { width: 100%; border-collapse: collapse; }");
        pw.println("th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
        pw.println("th { background-color: #f2f2f2; }");
        pw.println("tr:hover { background-color: #f5f5f5; }");
        pw.println("body { font-family: Arial, sans-serif; margin: 20px; }");
        pw.println("</style>");
        pw.println("<table border='1'><tr><th>PlanID</th><th>PlanName</th><th>PlanDuration</th></tr>");
        try {
			response.setContentType("text/html");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gympproject","root","0000");
			

			PreparedStatement ps=con.prepareStatement("select * from plans");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></td></tr>");
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("</table>");
        pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
