<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<title>Choose Your Login Account</title>

	<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/login.css' />" />
	<script type="text/javascript" src="" /></script>
</head>

<body>

	<header id="header">
		<a href="login.html?${samlstring}">
			<img src="<c:url value='/static/images/qg-coa.png' />" alt="QG Logo" width="289" height="50">
		</a>
	</header>
	
	<section id="mainsection">
		<h2>Queensland Government Account</h2>
		<h3>Providing secure access to online Government services</h3>
		<p>You are here because you requested access to a Queensland Government web site.</p> 
		<p>You may already have one of the accounts on the right. If so, you can use it to log in 
		now. Alternatively you can create a Queensland Government account for more secure access.
		</p>
		<p>This gives you full control over what information you share online.</p>
	</section>
	
	<aside id="loginoptions">
		<div id="selectaccount">Select an account</div>
		<div id="listofaccounts">
			<a href="/sso/UI/Login?${samlstring}&module=Google">
				<div id="google" class="accounts">
					<img src="<c:url value='/static/images/google_logo_square.jpg' />" alt="google" height="40px" width="40px" />
					<span class="accountlinks">
						<p>Google</p>
						<p class="linkdescription">user@gmail.com</p>
					</span>
					<span class="arrow">
						<img src="<c:url value='/static/images/greaterthan.png' />" />
					</span>
				</div>
			</a>
			<a href="underconstruction.html?${samlstring}">
				<div id="australianbusinessaccounts" class="accounts">
					<img src="<c:url value='/static/images/aba.png' />" alt="Australian Business Accounts" height="40px" width="40px" />
					<span class="accountlinks">
						<p>Australian Business Accounts</p>
						<p class="linkdescription">username</p>
					</span>
					<span class="arrow">
						<img src="<c:url value='/static/images/greaterthan.png' />" />
					</span>
				</div>
			</a>
			<a href="underconstruction.html?${samlstring}">
				<div id="auskey" class="accounts">
					<img src="<c:url value='/static/images/auskey.jpg' />" alt="auskey" height="40px" width="40px" />
					<span class="accountlinks">
						<p>AUSkey</p>
						<p class="linkdescription">your AUSkey</p>
					</span>
					<span class="arrow">
						<img src="<c:url value='/static/images/greaterthan.png' />" />
					</span>
				</div>
			</a>
			<a href="/sso/UI/Login?${samlstring}&module=DataStore">
				<span id="preferred">&nbsp;</span>
				<div id="queenslandgovernment" class="accounts">
					<img src="<c:url value='/static/images/qglogo.png' />" alt="Queensland Government" height="40px" width="40px" />
					<span class="accountlinks">
						<p>Queensland Government</p>
						<p class="linkdescription">your email address</p>
					</span>
					<span class="arrow">
						<img src="<c:url value='/static/images/greaterthan.png' />" />
					</span>
				</div>
			</a>
		</div>

		<div id="registeredit">
			<span id="register"><a href="underconstruction.html?${samlstring}">Register here</a></span>
			<span id="editsettings"><a href="underconstruction.html?${samlstring}">Manage</a></span>
		</div>
	</aside>
	
	<footer>
		<p>&copy; Queensland Government 2012</p>
	</footer>
	
</body>

</html>