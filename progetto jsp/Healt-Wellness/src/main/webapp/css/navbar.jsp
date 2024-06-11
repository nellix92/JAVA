<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<div class="navbar">
    <a  href="homeadmin.jsp">Home</a>
    <a class="active" href="UserServlet?mode=getall">Users</a>
    <a href="LogoutServlet" id="logout">Logout</a>
</div>
    <nav class="navbar">

        <a class="flex-logo text-decoration-none" href="home.jsp">
            <img src="images/logo.houseity.svg" alt="mini logo">
            <span>
                HOUSEITY
            </span>
        </a>
        <ul>
            <li>
                <a href="home.jsp" class="nav-link"> Home</a>
            </li>
            <li>
                <a href="UserServlet?mode=readProfilo" class="nav-link"> Profilo</a>
            </li>
            <li>
                <a href="LogoutServlet" class="nav-link" >Logout</a>
            </li>
        </ul>
    </nav>


</body>
</html>