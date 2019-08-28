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
public class CustomerLogin1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telecom","root","welcome");
			int id=	Integer.parseInt(request.getParameter("tf1"));
			String pass=request.getParameter("tf2");

			PreparedStatement pst=c.prepareStatement("select user_password from user_contact where user_id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			HttpSession hs=request.getSession();
			while(rs.next())
			{
				String dbpwd=rs.getString(1);
				if(dbpwd.equals(pass))
				{
					hs.setAttribute("LOGIN", id);
					response.sendRedirect("CustomerHome.jsp");


				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.html");
					rd.include(request, response);
					out.println("<html><body background=images/signup-bg.jpg");
					out.println("<br>");
					out.println("<center><b><font color=red size=18>Mismatch Of Password/Invalid User_id</font></b></center>");
					out.println("</html></body>");



				}
				PreparedStatement stmt=c.prepareStatement("select user_name,user_mail,user_address from user_contact where user_id=?");
				stmt.setInt(1,id);
				ResultSet rs1= stmt.executeQuery();
				String name=null;
				String mail=null;
				String address=null;
				while(rs1.next())
				{
				name= rs1.getString(1);
				mail= rs1.getString(2);
				address= rs1.getString(3);
				}
				HttpSession hs1=request.getSession();
				hs1.setAttribute("name",name);
				HttpSession hs2=request.getSession();
				hs2.setAttribute("mail",mail);
				HttpSession hs3=request.getSession();
				hs3.setAttribute("address",address);
				
			}
		}
		catch(Exception e)
		{
			out.println(e);

		}


	}
}