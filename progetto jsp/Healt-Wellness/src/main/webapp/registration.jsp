<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="java.util.List"
         import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <link href="css/style.css" rel="stylesheet">
  <title>Registration</title>
</head>
<body>


<div class="main">

  <figure>

    <img src="images/logo.houseity.svg" alt="logo contrader">
  </figure>

  <form class="registration-form" action="RegistrationServlet" method="post">
    <h1 id="title">Registrazione</h1>
    <div class="form-group">
      <label for="user">Username </label>
      <input type="text" id="user" name="username" placeholder="Inserisci username..." required>
    </div>
    <div class="form-group">
      <label for="pass">Password </label>
      <input type="password" id="pass" name="password" placeholder="Inserisci password..." required>
    </div>
    <div class="form-group">
              <label for="usertype"> Scegli il tuo User Type </label>
              <select name="usertype" id="usertype" required>
                <option value="USER"> Utente</option>
                <option value="ADMIN"> Admin</option>
              </select>
    </div>
    <div class="button-wrapper">

      <button type="submit" value="insert" name="pulsante">Crea Account</button>
    </div>
     <span>Sei gi&aacute registrato! Esegui il</span>
     <a class="back" href="index.jsp"> Login</a>
  </form>

</div>

<%--<%@ include file="../css/footer.jsp" %>--%>
</body>
</html>