<%@ page import="customer.*" %>


<%
		HttpSession hs=request.getSession(true);
		hs.invalidate();
		//response.sendRedirect("userlogin.html");
		response.sendRedirect("CustomerLogin.html");
		
%>