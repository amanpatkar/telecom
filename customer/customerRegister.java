package customer;

import java.io.IOException;
import java.io.PrintWriter;
import customer.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.CustomerGS;
import customer.CustomerDAO;
public class customerRegister extends HttpServlet {
	

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
		out.println("<div class=logout ></div></a></div><br><br><br><br><br>");

		out.println("<a class=button href=http://localhost:8080/Telecom/homepage.html ><b>HOME</b>");
		out.println("<div class=logout ></div></a></div><br><br><br>");



		 int id = Integer.parseInt(request.getParameter("tf1"));
		String name = request.getParameter("tf2");
		String mail = request.getParameter("tf3");
		String add = request.getParameter("tf4");
		String sques = request.getParameter("tf7");
		String sans = request.getParameter("tf8");
		String user_password = request.getParameter("tf5");
		String cpass = request.getParameter("tf6");
		String operator = request.getParameter("tf9");
		HttpSession hr=request.getSession();
		hr.setAttribute("operator",operator);
		HttpSession ht=request.getSession();
		 ht.setAttribute("name",name);
		
		try {
			CustomerGS obj = new CustomerGS();
			CustomerDAO dao = new CustomerDAO();
			obj.setUser_id(id);
			obj.setUser_name(name);
			obj.setUser_mail(mail);
			obj.setUser_address(add);
			obj.setSecurity_question(sques);
			obj.setSecurity_answer(sans);
			obj.setUser_password(user_password);
			obj.setOperator(operator);
			obj.setApproval("No");
			if(user_password.equals(cpass))
			{

				dao.insertCustomer(obj);
				//RequestDispatcher rd=request.getRequestDispatcher("CustomerInsertion.html");
				//rd.include(request, response);
				out.println("<body background=images/signup-bg.jpg");
				out.println("<br><br><br>");
				out.println("<center><b><font size=18>Your registration for "+operator+ " is under Approval "+"</font></b></center>");
				out.println("</html></body>");
			}
			else
			{	
				out.println("<html><body background=images/signup-bg.jpg");
				out.println("<br><br><br>");
				out.println("<center><b><font size=18>YOUR ENTERED CONFIRM PASSWORD DID NOT MATCH</font></b></center>");
				out.println("</html></body>");
			}




		} catch (Exception e) {

			out.println(e);
		}


	}

}