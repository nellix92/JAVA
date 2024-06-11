<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
     <%@ include file="/css/navbar.jsp"%>
    <div class="main container d-flex">
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("users");
        %>

        <table class="table rounded table-striped-columns">
            <thead>
                <tr>
                    <th class="text-primary-emphasis" scope="col">ID</th>
                    <th class="text-primary-emphasis" scope="col">Username</th>
                    <th class="text-primary-emphasis" scope="col">Password</th>
                    <th class="text-primary-emphasis" scope="col">Usertype</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <%
                for (UserDTO u : list) {
            %>
            <tr>
                <th scope="row"><a href=UserServlet?mode=read&id=<%=u.getId()%>>
                    <%=u.getId()%>
                </a></th>
                <td><%=u.getUsername()%></td>
                <td><%=u.getPassword()%></td>
                <td><%=u.getUsertype()%></td>
                <td><a href=UserServlet?mode=read&id=<%=u.getId()%>> Dettaglio</a></td>
            </tr>
            </tbody>
            <%
                }
            %>
        </table>

        <form class="create-form" action="UserServlet?mode=insert" method="post">
            <h1 id="title">Aggiungi utente</h1>
            <div class="form-group">
                <label for="user">Username </label>
                <input type="text" id="user" name="username" placeholder="Inserisci username..." required>
            </div>
            <div class="form-group">
                <label for="pass">Password </label>
                <input type="password" id="pass" name="password" placeholder="Inserisci password..." required>
            </div>
            <div class="form-group">

                <label for="type">Usertype</label>
                <select id="type" name="usertype">
                    <option value="ADMIN">ADMIN</option>
                    <option value="USER">USER</option>
                </select>

            </div>
            <div class="button-wrapper">

                <button type="submit" >Crea Account</button>
            </div>
        </form>
    </div>

     <%@ include file="/css/footer.jsp"%>

</body>
</html>