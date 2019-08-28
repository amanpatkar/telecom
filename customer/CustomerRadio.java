package customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import plan.*;

public class CustomerRadio extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		PrintWriter out=response.getWriter();
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

	
		out.println("</style></head>");
		try
		{
			HttpSession hs = request.getSession();
			Object o = hs.getAttribute("LOGIN");
			int str = (Integer) o;

			out.println("<div class=navigation align=right>");
			out.println("<a class=button href= ><b>LoginUser ID:" + str + "</b>");
			out.println("<div class=logout ></div></a></div><br><br><br><br><br>");
			
			out.println("<a class=button href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp ><b>SIGNOUT</b>");
			out.println("<div class=logout ></div></a></div><br><br><br>");

			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telecom","root","welcome");
			String plan_type=request.getParameter("to1");
			HttpSession ht=request.getSession();
			ht.setAttribute("type", plan_type);
			if(plan_type.equals("Prepaid"))
			{
				out.println("<body background=images/signup-bg.jpg><center><table border=5>");
				out.println("<section class=signup>");
				out.println("<div class= container>");
				out.println("<div class= signup-content>");
				out.println("<div class=form-group>");
				out.println("<form method=get action=PrepaidSelvlet1");
				out.println("<br><br>");
				out.println("<thead><tbody bgcolor=white>");
				out.println("<tr><th>Plan</th><th>Description</th><th>Price(RS.)</th></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Prepaid_Plan1 required/>Unlimited pack</td><td> The plan comes with a validity period of 28 days from the date of recharge.</td><td> Rs.199/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Prepaid_Plan2 required/>Recharge pack</td><td>It is a new prepaid bundle at ₹299 to offer 28 days of Amazon Prime membership along with 2.5GB data per day, unlimited calls to any network and 100 SMS per day.</td><td> Rs.299/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Prepaid_Plan3 required/>First Prepaid Reacharge</td><td>Airtels First Recharge plans is Rs 178 and it offers benefits of unlimited local, STD and roaming outgoing calls, 100 SMS per day and 1GB of 3G/4G data for a period of 28 days.</td><td> Rs.178/-</td></tr>");
				out.println("</tbody></thead></table>");
				out.println("<br><br>");
				out.println("<input type=submit value=Submit /></form></div>");
				out.println("</div></div></section>");
				out.println("</center></body></html>");
			}
			else if(plan_type.equals("Postpaid"))
			{
				out.println("<html><body background=images/signup-bg.jpg><center><table border=5>");
				out.println("<section class=signup>");
				out.println("<div class= container>");
				out.println("<div class= signup-content>");
				out.println("<div class=form-group>");
				out.println("<form method=get action=PrepaidSelvlet1");
				out.println("<br><br>");
				out.println("<thead><tbody bgcolor=white>");
				out.println("<tr><th>Plan</th><th>Description</th><th>Price(RS.)</th></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Postpaid_Plan1 required/>Monthly pack</td><td>For Prime Customers Ony:Benefits:Free Vioce,Unlimited Data(1.5 gb per day high speed data,thereafter unlimited at @64kb/s),100SMS per day.</td><td> Rs.1699/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Postpaid_Plan2 required/>Recharge pack</td><td>It is a new postpaid bundle at 299 to offer 28 days of Amazon Prime membership along with 2.5GB data per day, unlimited calls to any network and 100 SMS per day.</td><td> Rs.299/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=Postpaid_Plan3 required/>First Postpaid Reacharge</td><td> Airtel First Recharge plans is Rs 178 and it offers benefits of unlimited local, STD and roaming outgoing calls, 100 SMS per day and 1GB of 3G/4G data for a period of 28 days.</td><td> Rs.178/-</td></tr>");
				out.println("</tbody></thead></table>");
				out.println("<br><br>");
				out.println("<input type=submit value=Submit /></form></div>");
				out.println("</div></div></section>");
				out.println("</center></body></html>");

			}
			else if(plan_type.equals("Landline"))
			{
				out.println("<html><body background=images/signup-bg.jpg><center><table border=5>");
				out.println("<section class=signup>");
				out.println("<div class= container>");
				out.println("<div class= signup-content>");
				out.println("<div class=form-group>");
				out.println("<form method=get action=PrepaidSelvlet1");
				out.println("<br><br>");
				out.println("<thead><tbody bgcolor=white>");
				out.println("<tr><th>Plan</th><th>Description</th><th>Price(RS.)</th></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=LandLine_Plan1 required/>Monthly pack</td><td>Unlimited local+STD calls+internet speed upto 40mbps,100GB data.</td><td> Rs.799/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=LandLine_Plan2 required/>Monthly pack</td><td>Unlimited local+STD calls+internet speed upto 1000mbps,250GB data,data roll over,amazon prime subscription.</td><td> Rs.999/-</td></tr>");
				out.println("<tr><td><input type=radio name=tp1 value=LandLine_Plan3 required/>Monthly pack</td><td>Unlimited local+STD calls+internet speed upto 1000mbps,500GB data,data roll over,amazon prime subscription.</td><td> Rs.1299/-/-</td></tr>");
				out.println("</tbody></thead></table>");
				out.println("<br><br>");
				out.println("<input type=submit value=Submit /></form></div>");
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