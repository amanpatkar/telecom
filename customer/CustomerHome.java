package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CustomerHome extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		String optn=request.getParameter("t1");
		if(optn.equals("planselection"))
		{
			response.sendRedirect("http://localhost:8080/Telecom/customerRadio.jsp");
		}
		else if(optn.equals("billpayment"))
		{
			response.sendRedirect("http://localhost:8080/Telecom/BillRadio.jsp");
		}
		else if(optn.equals("cncttermination"))
		{
			response.sendRedirect("http://localhost:8080/Telecom/CustomerTermination");
		}
		else if(optn.equals("addupdate"))
		{
			response.sendRedirect("http://localhost:8080/Telecom/CustomerUpdate.jsp");	
		}

	}

}
