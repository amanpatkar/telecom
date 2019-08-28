package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Termination2 extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		int choice=Integer.parseInt(request.getParameter("tf2"));
		String radio= request.getParameter("tf1");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");
			
			if(radio.equals("approve"))
			{
				PreparedStatement pst= c.prepareStatement("update customer_termination set status=? where user_id=?");
				pst.setString(1, "yes");
				pst.setInt(2, choice);
				pst.execute();
				RequestDispatcher rd=request.getRequestDispatcher("Termination1");
				rd.include(request, response);
				out.println("<center><font size=15 color=red>*Done*</font></center>");
				
			}
			else if(radio.equals("reject"))
			{
				PreparedStatement pst= c.prepareStatement("update customer_termination set status=? where user_id=?");
				pst.setString(1, "reject");
				pst.setInt(2, choice);
				pst.execute();
				RequestDispatcher rd=request.getRequestDispatcher("Termination1");
				rd.include(request, response);
				out.println("<center><font size=15 color=red>*Done*</font></center>");
				
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}


}
