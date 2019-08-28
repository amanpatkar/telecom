package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdminLogin1 extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String user=request.getParameter("tf1");
		String pass=request.getParameter("tf2");
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");
			HttpSession aa=request.getSession();
			aa.setAttribute("admin",user);

			PreparedStatement pst=c.prepareStatement("select admin_pwd from admin where admin_id=?");
			pst.setString(1,user );
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			 String dbpwd=rs.getString(1);
				if(dbpwd.equals(pass))
				{
					
					response.sendRedirect("AdminLogin1.jsp");
					
					
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
					rd.include(request, response);
					out.println("<center><h1>Please Enter correct password</h1></center>");
					
					
					
				}
		
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	

}
}