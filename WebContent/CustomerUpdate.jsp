<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="customer.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.PrintWriter"%>
<html lang="en">
<head>
<style>
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
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign up</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
HttpSession hs=request.getSession();
Object o=hs.getAttribute("LOGIN");
int str=(Integer)o;
HttpSession hs1=request.getSession();
Object o1=hs1.getAttribute("name");
String str1=(String)o1;
HttpSession hs2=request.getSession();
Object o2=hs2.getAttribute("mail");
String str2=(String)o2;
HttpSession hs3=request.getSession();
Object o3=hs3.getAttribute("address");
String str3=(String)o3;
out.println("<div align=right><font color=red>LoginUser Name:"+str1+"</font></div><br>");
out.println("<div align=right><a href=http://localhost:8080/Telecom/CustomerRadioLogout.jsp>SIGNOUT</a></div>");

%>

	<div class="main">

		<section class="signup">
			<!-- <img src="images/signup-bg.jpg" alt=""> -->
			<div class="container">
				<div class="signup-content">
					<form method="GET" id="signup-form" class="signup-form"
						action="CustomerUpdate1">
						<h2 class="form-title">Customer Registration Form</h2>
						<div class="form-group">
							<input type="text" class="form-input" name="tf8" id="id"
								placeholder="Your ID" value=<% out.println(str); %> disabled />
						</div>
						<div class="form-group">
							<input type="text" class="form-input" name="tf2" id="name"
								placeholder="Your Name" value=<% out.println(str1); %> disabled />
						</div>
						<div class="form-group">
							<input type="email" class="form-input" name="tf3" id="email"
								placeholder="Your Email" value=<% out.println(str2); %> disabled />
						</div>
						<div class="form-group">
							<textarea class="form-input" rows="7" cols="29" name="tf4"
								id="address" placeholder="Your Address"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" id="submit"
								class="form-submit" value="Update" />
						</div>
					</form>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>
