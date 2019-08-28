package customer;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CustomerTermination1 extends HttpServlet 
{
	Connection c=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");
			HttpSession hs = request.getSession();
			Object o = hs.getAttribute("LOGIN");
			int str = (Integer) o;
			out.println("<div class=navigation align=right>");
			out.println("<a class=button href= ><b>LoginUser ID:" + str + "</b>");
			out.println("<div class=logout ></div></a></div><br><br><br><br><br>");

			out.println("<a class=button href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp ><b>SIGNOUT</b>");
			out.println("<div class=logout ></div></a></div><br><br><br>");


			String reason=request.getParameter("c1");
			int cc= Calendar.getInstance().getTime().getDate();
			SimpleDateFormat datetime = new SimpleDateFormat("dd-MM-yyyy:hh:mm:ss");
			Date date = new Date();
			String dt = datetime.format(date);

			PreparedStatement pst=c.prepareStatement("insert into customer_termination values(?,?,?,?)");
			pst.setInt(1,str);
			pst.setString(2, dt);
			pst.setString(3,reason);
			pst.setString(4,"no");
			pst.execute();
			out.println("<body background=images/signup-bg.jpg>");
			out.println("<center><font color=red><h1><b>YOUR CONNECTION TERMINATION REQUEST IS SUBMITTED .THE REQUEST WILL BE PROCESS SOON.</b></h1></font></center>");
			out.println("</body></html>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}