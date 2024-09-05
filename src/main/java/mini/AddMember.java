package mini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMember
 */
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String a=request.getParameter("id");
			String b=request.getParameter("name");
			String c=request.getParameter("planId");
			String d=request.getParameter("trainerId");
			int f=Integer.parseInt(a);
			int g=Integer.parseInt(c);
			int h=Integer.parseInt(d);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gympproject","root","0000");
				PreparedStatement ps=conn.prepareStatement("insert into member values(?,?,?,?)");
				ps.setInt(1, f);
				ps.setString(2, b);
				ps.setInt(3, g);
				ps.setInt(4, h);
				int rs=ps.executeUpdate();
				if(rs>0) {
				pw.println("<h1>records inserted</h1>");
				System.out.println(rs+"you have been added");}
				else {
					pw.println("<h1>records not inserted</h1>");
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request,response);	
	}

}
