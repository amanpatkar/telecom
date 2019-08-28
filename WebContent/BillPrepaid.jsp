<html>
<head>
<style>
.rButton {
	width: 13px;
	height: 12px;
}

.convText {
	font-family: 'Segoe UI';
	font-size: 30px;
}

.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
	}
.navigation {
   width: 100%;
  background-color: black;
}
.logout {
  font-size: .8em;
  font-family: 'Oswald', sans-serif;
	position: relative;
  right: -18px;
  bottom: -4px;
  overflow: hidden;
  letter-spacing: 3px;
  opacity: 0;
  transition: opacity .45s;
  -webkit-transition: opacity .35s;
  
}

.button {
	text-decoration: none;
	float: right;
  padding: 12px;
  margin: 15px;
  color: white;
  width: 25px;
  background-color: black;
  transition: width .35s;
  -webkit-transition: width .35s;
  overflow: hidden;
   border-radius: 5px 0 0 5px;
  
}

a:hover {
  width: 100px;
}

a:hover .logout{
  opacity: .9;
}

a {
  text-decoration: none;
}
}
</style>
</head>
<body>

	<%
	HttpSession hs = request.getSession();
	Object o = hs.getAttribute("LOGIN");
	int str = (Integer) o;

	out.println("<div class=navigation align=right>");
	out.println("<a class=button href= ><b>LoginUser ID:" + str + "</b>");
	out.println("<div class=logout ></div></a></div><br><br><br><br><br>");
	
	out.println("<a class=button href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp ><b>SIGNOUT</b>");
	out.println("<div class=logout ></div></a></div><br><br><br>");
	

		HttpSession hd = request.getSession();
		Object o2 = hd.getAttribute("plan_model");
		String str2 = (String) o2;

		HttpSession ht2 = request.getSession();
		Object o3 = ht2.getAttribute("type");
		String str3 = (String) o3;

		if (str2.equals("Prepaid_Plan1")) {
			//out.println(str2);

			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<html><body background=images/signup-bg.jpg><center><table border=2><thead><tbody color=white >");
			out.println("<thead><tbody bgcolor=white >");
			out.println("<tr><td>Unlimited pack</td><td> The plan comes with a validity period of 28 days from the date of recharge.</td><td> Rs.199/-</td></tr>");
			out.println("</tbody></thead></table></center></body></html>");

		} else if (str2.equals("Prepaid_Plan2")) {
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");

			out.println("<html><body background=images/signup-bg.jpg><center><table border=2><thead><tbody bgcolor=white >");
			out.println(
					"<tr><td>Recharge pack</td><td>It is a new prepaid bundle at 299 to offer 28 days of Amazon Prime membership along with 2.5GB data per day, unlimited calls to any network and 100 SMS per day.</td><td> Rs.299/-</td></tr>");

			out.println("</tbody></thead></table></center></body></html>");

		} else if (str2.equals("Prepaid_Plan3")) {
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");

			out.println("<html><body background=images/signup-bg.jpg><center><table border=2><thead><tbody bgcolor=white>");
			out.println(
					"<tr><td>First Prepaid Reacharge</td><td>Airtel’s First Recharge plans is Rs 178 and it offers benefits of unlimited local, STD and roaming outgoing calls, 100 SMS per day and 1GB of 3G/4G data for a period of 28 days.</td><td> Rs.178/-</td></tr>");

			out.println("</tbody></thead></table></center></body></html>");
		}
	%>
	<br>
	<br>
	<form method="get" action="BillPrepaid">
		<center>

			<input type="submit" value="PAY AMOUNT">
		</center>
	</form>

	<%
		
	%>
</body>
</html>