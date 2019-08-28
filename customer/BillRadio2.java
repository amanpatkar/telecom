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
import javax.servlet.http.HttpSession;
public class BillRadio2 extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs=request.getSession();
		Object o=hs.getAttribute("LOGIN");
		int str=(Integer)o;

		PrintWriter out= response.getWriter();
		String radio= request.getParameter("tf1");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");
			
			if(radio.equals("yes"))
			{
				PreparedStatement pst= c.prepareStatement("update postpaid set paid_status=? where user_id=?");
				pst.setString(1, "yes");
				pst.setInt(2, str);
				pst.execute();
				RequestDispatcher rd=request.getRequestDispatcher("BillRadio");
				rd.include(request, response);
				out.println("<center><font size=15 color=red>*Payment Done*</font></center>");
				
			}
			else if(radio.equals("no"))
			{
				PreparedStatement pst= c.prepareStatement("update postpaid set paid_status=? where user_id=?");
				pst.setString(1, "No");
				pst.setInt(2, str);
				pst.execute();
				response.sendRedirect("CustomerHome.jsp");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}


}
