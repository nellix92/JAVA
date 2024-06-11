<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="java.util.List"
         import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="ISO-8859-1">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

      <title>Registration</title>
      <script>
      function showErrorMessage() {
          document.getElementById("alert").style.display = "block";
      }
      </script>
      <style>
        .registration-form {
            max-width: 400px;
            border-radius: 5px;
            padding: 20px;
            margin-top: 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-control {
            border-radius: 5px;
            border: 1px solid #ccc;
            padding: 10px;
            box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
        }
        .form-control:focus {
            border-color: #444;
            box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
        }
        .button-wrapper {
            text-align: center;
            margin-top: 20px;
        }
        .button-wrapper button {
            border-radius: 5px;
            padding: 10px 20px;
            background-color: #444;
            color: #fff;
            border: 1px solid #444;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }
        .button-wrapper button:hover {
            background-color: #333;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
        .back {
            color: #333;
            text-decoration: none;
        }
        .back:hover {
            text-decoration: underline;
        }
      </style>
</head>
<body>
<div class="main container text-center">
      <form class="registration-form" action="/user/insert" method="post">
            <h1 id="title">Registrazione</h1>
        <div class="form-group">
          <label for="user">Username </label>
          <input type="text" id="user" name="username" placeholder="Inserisci username..." required class="form-control">
        </div>
        <div class="form-group">
          <label for="pass">Password </label>
          <input type="password" id="pass" name="password" placeholder="Inserisci password..." required class="form-control">
        </div>
        <div class="form-group">
          <label for="usertype"> Scegli il tuo User Type </label>
          <select name="usertype" id="usertype" required class="form-control">
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
    <div id="alert" style="display: none;">
        Username già presente.
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