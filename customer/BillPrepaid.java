package customer;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class BillPrepaid extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecom","root","welcome");

			HttpSession hs=request.getSession();
			Object o=hs.getAttribute("LOGIN");
			int str=(Integer)o;

			///*int cc= Calendar.getInstance().getTime().getDate();
			SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String dt = datetime.format(date);


			HttpSession ht2=request.getSession();
			Object o3= ht2.getAttribute("type");
			String str3=(String)o3;

			HttpSession hd = request.getSession();
			Object o2 = hd.getAttribute("plan_model");
			String str2 = (String) o2;





			PreparedStatement pst1=c.prepareStatement("insert into prepaid values(?,?,?,?,?)");
			PreparedStatement pst2=c.prepareStatement("select amount from plan where user_id=?");
			pst2.setInt(1,str);
			ResultSet rs2=pst2.executeQuery();
			pst1.setInt(1, str);
			pst1.setString(2,dt);

			while(rs2.next())
			{
				pst1.setString(3,rs2.getString(1));
			}
			pst1.setString(4,"yes");
			pst1.setString(5, dt);
			pst1.execute();



			PreparedStatement pst4=c.prepareStatement("update prepaid set validity_date =adddate(rg_date,interval 28 day)  where user_id=?");
			pst4.setInt(1,str);
			pst4.execute();


			response.sendRedirect("BillPrepaid1");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}


	}

}