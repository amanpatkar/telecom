package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApprovalLandline1 extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String radio=request.getParameter("tf1");
		int id=Integer.parseInt(request.getParameter("tf2"));
			try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");


			if(radio.equals("approve"))
			{
				PreparedStatement pst= c.prepareStatement("update plan set status=? where user_id=?");
				pst.setString(1, "yes");
				pst.setInt(2, id);
				pst.execute();
				//out.println("done");
				
				SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String dt = datetime.format(date);

				PreparedStatement insert=c.prepareStatement("insert into landline values(?,?,?,?,?,?)");
				PreparedStatement select=c.prepareStatement("select amount from plan where user_id=?");
				select.setInt(1,id);
				ResultSet rs2=select.executeQuery();
				insert.setInt(1,id);
				insert.setString(2,dt);

				while(rs2.next())
				{
					insert.setString(3,rs2.getString(1));
				}
					insert.setString(4,"no");
					insert.setString(5, dt);
					insert.setString(6,dt);
					insert.execute();
					
					PreparedStatement pst4=c.prepareStatement("update landline set validity_date =adddate(rg_date,interval 28 day)  where user_id=?");
					pst4.setInt(1,id);
					pst4.execute();

					PreparedStatement pst5=c.prepareStatement("update landline set due_date =adddate(validity_date,interval 10 day)  where user_id=?");
					pst5.setInt(1,id);
					pst5.execute();
					RequestDispatcher rd=request.getRequestDispatcher("ApprovalLandline");
					rd.include(request, response);
					out.println("<center><font size=15 color=red>*Done*</font></center>");
			}
			else if(radio.equals("reject"))
			{
				PreparedStatement pst= c.prepareStatement("update plan set status=? where user_id=?");
				pst.setString(1, "reject");
				pst.setInt(2, id);
				pst.execute();
				RequestDispatcher rd=request.getRequestDispatcher("ApprovalLandline");
				rd.include(request, response);
				out.println("<center><font size=15 color=red>*Done*</font></center>");
				/*SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String dt = datetime.format(date);

				PreparedStatement insert=c.prepareStatement("insert into postpaid values(?,?,?,?,?,?)");
				PreparedStatement select=c.prepareStatement("select amount from plan where user_id=?");
				select.setInt(1,id);
				ResultSet rs2=select.executeQuery();
				insert.setInt(1,id);
				insert.setString(2,dt);

				while(rs2.next())
				{
					insert.setString(3,rs2.getString(1));
				}
					insert.setString(4,"no");
					insert.setString(5, dt);
					insert.setString(6,dt);
					insert.execute();
					
					PreparedStatement pst4=c.prepareStatement("update postpaid set validity_date =adddate(rg_date,interval 28 day)  where user_id=?");
					pst4.setInt(1,id);
					pst4.execute();

					PreparedStatement pst5=c.prepareStatement("update postpaid set due_date =adddate(validity_date,interval 10 day)  where user_id=?");
					pst5.setInt(1,id);
					pst5.execute();
					out.println("Done");*/


			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
