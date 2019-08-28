
package customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CustomerTermination extends HttpServlet 

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
				+ " background-color: red;\r\n" + 
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

		HttpSession hs=request.getSession();
		Object o=hs.getAttribute("LOGIN");
		int str=(Integer)o;

		out.println("<div class=navigation align=right>");
		out.println("<a class=button href= ><b>LoginUser ID:" + str + "</b>");
		out.println("<div class=logout ></div></a></div><br><br><br><br><br>");

		out.println("<a class=button href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp ><b>SIGNOUT</b>");
		out.println("<div class=logout ></div></a></div><br><br><br>");
		out.println("<head>");
		//out.println("</head>");
		out.println("<body background=images/signup-bg.jpg><center>");
		out.println("<form method=get action=CustomerTermination1>");
		out.println("<h1>WHY TERMINATION? :( <h1>");
		out.println("<br>");
		out.println("Reason:<br><textarea rows=10 cols=55 placeholder=your response is valuable to us> </textarea><br><br>");
		out.println("<input type=radio class=rButton name=c1 id=id");
		out.println("value=NetworkIssue required /><span class=convText> Network Issue</span><br><br>");
		out.println("<input type=radio class=rButton name=c1 id=id");
		out.println("value=PoorServices required /><span class=convText>Poor Services</span><br><br>");
		out.println("<input type=radio class=rButton name=c1 id=id");
		out.println("value=Place required /><span class=convText>Changing your place</span><br><br>");
		out.println("<input class=button5 type=submit value=Termiate />");
		out.println("</form>");
		out.println("</center></body>");
		out.println("</head></html>");
	}

}
