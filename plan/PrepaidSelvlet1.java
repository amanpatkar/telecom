package plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.*;
import customer.CustomerGS;
import customer.DBConnection;
public class PrepaidSelvlet1 extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telecom","root","welcome");

			HttpSession hs=request.getSession();
			Object o=hs.getAttribute("LOGIN");
			int str=(Integer)o;

			String plan_model=request.getParameter("tp1");

			HttpSession hd=request.getSession();
			hd.setAttribute("plan_model",plan_model);

			HttpSession ht=request.getSession();
			Object o1= ht.getAttribute("type");
			String str1=(String)o1;

			String plan_type=request.getParameter("to1");

			PreparedStatement pst=c.prepareStatement("select operator from user_contact where user_id=?");
			pst.setInt(1,str);
			ResultSet rs= pst.executeQuery();

			response.setContentType("text/html");
			PreparedStatement stmt=c.prepareStatement("insert into plan values(?,?,?,?,?,?)");

			if(plan_model.equals("Prepaid_Plan1"))
			{  
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5, " Rs.199");
				stmt.setString(6,"Y");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=10><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid.jsp");
				}

			}
			else if(plan_model.equals("Prepaid_Plan2") )
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5, "Rs. 299");
				stmt.setString(6,"Y");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid.jsp");
				}



			}
			else if( plan_model.equals("Prepaid_Plan3"))
			{

				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5, "Rs. 178");
				stmt.setString(6,"Y");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid.jsp");
				}


			}
			else if(plan_model.equals("Postpaid_Plan1"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 1699/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}


			}
			else if(plan_model.equals("Postpaid_Plan2"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 299/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}

			}
			else if(plan_model.equals("Postpaid_Plan3"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 178/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}

			}
			else if(plan_model.equals("LandLine_Plan1"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 799/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}

			}
			else if(plan_model.equals("LandLine_Plan2"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 999/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}

			}

			else if(plan_model.equals("LandLine_Plan3"))
			{
				stmt.setInt(1,str);
				stmt.setString(2,str1);
				stmt.setString(3,plan_model);
				while(rs.next())
				{
					stmt.setString(4,(rs.getString(1)));
				}
				stmt.setString(5,"Rs. 1299/-");
				stmt.setString(6,"N");
				PreparedStatement ps=c.prepareStatement("select user_id from plan where user_id=?");
				ps.setInt(1,str);
				ResultSet t= ps.executeQuery();
				int r=0;
				while(t.next())
				{
					r=t.getInt(1);
				}
				if(str==r)
				{
					out.println("<div background=black><center><font color=red size=18><b><u>Your plan request is already activated in your operator. </u></b></font></center></div>");
					RequestDispatcher rt= request.getRequestDispatcher("customerRadio.jsp");
					rt.include(request, response);

				}
				else
				{
					stmt.execute();
					response.sendRedirect("BillPrepaid1");
				}


			}
		}

		catch(Exception e)
		{
			out.println(e);
		}
	}

}
