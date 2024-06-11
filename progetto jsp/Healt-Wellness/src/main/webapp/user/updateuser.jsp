<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="css/style.css" rel="stylesheet">
    <title>Edit User</title>
</head>
<body>
    <%@ include file="/css/navbar.jsp"%>

    <div class="main container">

        <%UserDTO u = (UserDTO) request.getAttribute("userToUpdate");%>

        <form class="create-form" action="UserServlet" method="post">
            <input type="hidden" name="mode" value="update">
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <h1 id="title">Modifica utente</h1>
            <div class="form-group">
                <label for="user">Username </label>
                <input type="text" id="user" name="username" value=<%=u.getUsername()%> required>
            </div>
            <div class="form-group">
                <label for="pass">Password </label>
                <input type="password" id="pass" name="password" value=<%=u.getPassword()%> required>
            </div>
            <div class="form-group">

                <label for="type">Usertype</label>
                <select id="type" name="usertype">
                    <option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
                    <option value="USER" <%if(u.getUsertype().equals("USER")) {%>selected<%}%>>USER</option>
                </select>

            </div>
            <div class="button-wrapper">

                <button type="submit" >Modifica Account</button>
            </div>
        </form>

    </div>

     <%@ include file="/css/footer.jsp"%>
</body>
</html>