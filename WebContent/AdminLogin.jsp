<!DOCTYPE html>
<html lang="en">
<head>
<style>
#mySidenav a {
  position: absolute;
  left: -80px;
  transition: 0.3s;
  padding: 15px;
  width: 100px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
  left: 0;
}
#blog {
  top: 80px;
  background-color: #2196F3;
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
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<style>
.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15 px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}
</style>
<body>
		<div id="mySidenav" class="sidenav">
		<a  href="homepage.html" id="blog"><b>HOME</b></a>
			
	</div>
	<br>
<div class="main">

		<section class="signup">
			<!-- <img src="images/signup-bg.jpg" alt=""> -->
			<div class="container">
				<div class="signup-content">
					<form method="GET" id="signup-form" class="signup-form"
						action="AdminLogin1.jsp">
						<h2 class="form-title">Admin Account Login</h2>
						<div class="form-group">
							<input type="text" class="form-input" name="tf1" id="id"
								placeholder="Your ID" required />
						</div>
						<div class="form-group">
							<input type="text" class="form-input" name="tf2" id="password"
								placeholder="Password" required /> <span toggle="#password"
								class="zmdi zmdi-eye field-icon toggle-password"></span>
						</div>

						<br>



						<div class="form-group">
							<input type="submit" name="submit" id="submit"
								class="form-submit" value="Sign in" />
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