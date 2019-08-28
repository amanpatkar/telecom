package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
public class BillRadio extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><style>");
		out.println(".navigation "
				+ "{ "
				+ "width: 100%; "
				+ "background-color: "
				+ "black;	"
				+ "}");
		out.println(".logout "
				+ "{"
				+ " font-size: .8em; "
				+ "font-family: 'Oswald', sans-serif; "
				+ "position: relative; "
				+ "right: -18px;"
				+ "bottom: -4px;"
				+ "overflow: hidden;"
				+ "letter-spacing: 3px;	"
				+ "opacity: 0; "
				+ "transition: opacity .45s;"
				+ " -webkit-transition: opacity .35s;"
				+ "	}");

		out.println(".button"
				+ " {"
				+ "text-decoration: none;"
				+ "float: right;"
				+ "padding: 12px;"
				+ "margin: 15px;"
				+ "color: white;"
				+ "width: 25px;"
				+ " background-color: black;"
				+ "transition: width .35s;"
				+ "  -webkit-transition: width .35s;"
				+ "overflow: hidden;"
				+ "border-radius: 5px 0 0 5px;	"
				+ "}");
		out.println("a:hover"
				+ " {"
				+ "	width: 100px;	"
				+ "}");

		out.println("a:hover "
				+ ".logout"
				+ "{ "
				+ "opacity: .9;"
				+ "	}");

		out.println("a "
				+ "{"
				+ " text-decoration: none;	"
				+ "}");
		out.println(".button5"
				+ "{ "
				+ " background-color: #4CAF50;\r\n" + 
				"  border: solid;" + 
				"  color: white;" + 
				"  padding: 5px;" + 
				"  text-align: center;" + 
				"  font-size: 16px;" + 
				"  margin: 4px 2px;" + 
				"  cursor: pointer;" + 
				"  border-radius: 30px;" + 
				"  width: 100px;" + 
				"  height: 80px;"
				+ "}");



		out.println("</style></head>");

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telecom","root","welcome");

			String pp= request.getParameter("b1");

			HttpSession hs=request.getSession();
			Object o=hs.getAttribute("LOGIN");
			int str=(Integer)o;

			out.println("<div class=navigation align=right>");
			out.println("<a class=button href= ><b>LoginUser ID:" + str + "</b>");
			out.println("<div class=logout ></div></a></div><br><br><br><br><br>");

			out.println("<a class=button href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp ><b>SIGNOUT</b>");
			out.println("<div class=logout ></div></a></div><br><br><br>");

			HttpSession hd = request.getSession();
			Object o2 = hd.getAttribute("plan_model");
			String str2 = (String) o2;

			HttpSession ht = request.getSession();
			Object o3 = ht.getAttribute("type");
			String str3 = (String) o3;

			if(pp.equals("Postpaid"))
			{
				String select="select * from postpaid where user_id=?";
				PreparedStatement pst=c.prepareStatement(select);
				pst.setInt(1,str);
				ResultSet rs=	pst.executeQuery();
				out.println("<body background=images/signup-bg.jpg><center>");
				out.println("<head><style>");
				out.println(".big {width: 2em; height: 2em; backgroung-color: #ccc; }");
				out.println(".next {background-color:pink  }");
				out.println(".first {background-color:yellow }");
				out.println("<section class=signup>");
				out.println("<div class= container>");
				out.println("<div class= signup-content>");
				out.println("<div class=form-group>");
				out.println("</style></head>");
				out.println("<table border=5>");
				out.println("<form method=get action=BillRadio2");
				//out.println("<br><br>");
				out.println("<thead><tbody bgcolor=white>");
				out.println("<tr><th>User_ID</th><th>Registration_Date</th><th>Amount</th><th>Paid_status</th><th>Validity_Date</th><th>Due_Date</th></tr>");

				while(rs.next())
				{
					out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");

				}
				out.println("</tbody></thead></table>");
				out.println("<br><br>");
				out.println("<font color=white size=8><b>Do You Want to Pay Now ?</b></font> <br><br>");
				out.println("<input type=radio class=big  value=yes name=tf1 required/><font color=white size=9>YES  </font>");
				out.println("<input type=radio class=big  value=no name=tf1 required/><font color=white size=9>NO</font><br><br>");
				out.println("<input class=button5 type=submit value=Pay />");
				out.println("</form></div>");
				out.println("</div></div></section>");
				out.println("</center></body></html>");


			}
			else if(pp.equals("Landline"))
			{
				String select="select * from landline";
				PreparedStatement pst=c.prepareStatement(select);
				ResultSet rs=	pst.executeQuery();
				out.println("<body background=images/signup-bg.jpg><center>");
				out.println("<head><style>");
				out.println(".big {width: 2em; height: 2em; backgroung-color: #ccc; }");
				out.println(".next {background-color:pink  }");
				out.println(".first {background-color:yellow }");
				out.println("<section class=signup>");
				out.println("<div class= container>");
				out.println("<div class= signup-content>");
				out.println("<div class=form-group>");
				out.println("</style></head>");
				out.println("<table border=5>");
				out.println("<form method=get action=BillRadio3");
				//out.println("<br><br>");
				out.println("<thead><tbody bgcolor=white>");
				out.println("<tr><th>User_ID</th><th>Registration_Date</th><th>Amount</th><th>Paid_status</th><th>Validity_Date</th><th>Due_Date</th></tr>");

				while(rs.next())
				{
					out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");

				}
				out.println("</tbody></thead></table>");
				out.println("<br><br>");
				out.println("<font color=white size=8><b>Do You Want to Pay Now ?</b></font> <br><br>");
				out.println("<input type=radio class=big  value=yes name=tf1 required/><font color=white size=9>YES  </font>");
				out.println("<input type=radio class=big  value=no name=tf1 required/><font color=white size=9>NO</font><br><br>");
				out.println("<input class=button5 type=submit value=Pay />");
				out.println("</form></div>");
				out.println("</div></div></section>");
				out.println("</center></body></html>");


			}
		}
		catch(Exception e)
		{
			out.println(e);
		}

	}

}
