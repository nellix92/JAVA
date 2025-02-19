<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Sample Login page">
<meta name="author" content="Vittorio Valent">

<title>Login</title>

<link href="/css/style.css" rel="stylesheet">
<script>
function showErrorMessage() {
    document.getElementById("alert").style.display = "block";
}
</script>
</head>


<body class="text-center">
	<form class="login" action="/user/login" method="post">
		<h1>SAMPLE LOGIN</h1>

        <label for="inputUser" class="sr-only">Username</label>
        <input type="text" name="username" id="inputUser" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <input type="hidden" name="richiesta" value="login">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
<a class="registration-btn" href="/registration.jsp">Registrati</a>
	</form>
	<div id="alert" style="display: none;">
            Username o password errati.
        </div>

        <%
           String errorMessage = (String) request.getAttribute("errorMessage");
           if(errorMessage != null && !errorMessage.isEmpty()) {
        %>
           <div style="color: red;">
               <%= errorMessage %>
           </div>
       <% } %>
</body>
</html>