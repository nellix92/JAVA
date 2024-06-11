<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Edit User</title>

<style>
.edit-form {
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.edit-form .form-group {
    margin-bottom: 15px;
}

.edit-form label {
    display: block;
    margin-bottom: 5px;
}

.edit-form input[type="text"],
.edit-form select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
}

.edit-form input[type="text"]:focus,
.edit-form select:focus {
    border-color: #444;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
}

.edit-form button {
    background-color: #444;
    color: #fff;
    border: 1px solid #444;
    border-radius: 5px;
    padding: 10px 20px;
    display: block;
    margin-top: 15px;
    width: 100%;
    cursor: pointer;
}

.edit-form button:hover {
    background-color: #333;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="../css/navbar.jsp" %>


<div class="main container text-center">

<%UserDTO u = (UserDTO) request.getSession().getAttribute("dto");%>


    <form class="edit-form" action="/user/update" method="post">
      <div class="form-group">
        <label for="user">Username</label>
        <input type="text" class="form-control" id="user" name="username" value=<%=u.getUsername()%>>
      </div>
      <div class="form-group">
        <label for="pass">Password</label>
        <input type="text" class="form-control" id="pass" name="password" value=<%=u.getPassword()%>>
      </div>
      <input type="hidden" name="id" value =<%=u.getId() %>>
      <button type="submit" class="btn btn-primary">Edit</button>

    </form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>