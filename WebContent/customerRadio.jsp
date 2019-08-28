<!DOCTYPE html>
<html lang="en">
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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Choice</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
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
	
	
	%>
		<div class="main">

		<section class="signup">
			<!-- <img src="images/signup-bg.jpg" alt=""> -->
			<div class="container">
				<div class="signup-content">
					<form method="GET" id="signup-form" class="signup-form"
						action="CustomerRadio">
						<h2 class="form-title">Select Your Connection</h2>
						<div class="form-group">
							<input type="radio" class="rButton" name="to1" id="id"
								value="Prepaid" required /><span class="convText"> Prepaid</span><br><br>
							<input type="radio" class="rButton" name="to1" id="id"
								value="Postpaid" required /><span class="convText"> Postpaid</span><br><br>
							<input type="radio" class="rButton" name="to1" id="id"
								value="Landline" required /><span class="convText"> Landline</span><br><br>
						</div>
						<br><br>
						<div class="form-group">
							<input type="submit" name="submit" id="submit"
								class="form-submit" value="Search" />
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