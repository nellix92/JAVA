<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Sample Login page">
  <meta name="author" content="Vittorio Valent">

  <title>Login</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <style>
    .col-btn {
      height: 200px;
    }

    a{
       height: 100%;
    }

    .btn-block {
      height: 100%;
    }

    .btn-block:hover {
      box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);
    }
  </style>

</head>
<body>

  <%@ page import="it.contrader.dto.UserDTO" %>
  <%@ page import="it.contrader.model.User.Usertype" %>

  <%@ include file="/css/navbar.jsp"%>

  <div class="main container text-center">
    <div class="row justify-content-center">

      <% //List<AgenziaDTO> list = (List<AgenziaDTO>) request.getAttribute("agenzia");
          UserDTO user = (UserDTO) request.getSession().getAttribute("user");
          it.contrader.model.User.Usertype usertype = user.getUsertype();
          %>

        <br><br>

      <h1>Welcome ${user.getUsername()}</h1>

        <br><br>
        <br><br>

      <div class="col-6 col-md-4 col-btn my-3">
       <a href="/casa/getall" class="nav-link homeButton">
        <button class="btn btn-outline-dark mb-3 btn-block">
            <h2>
                <i class="fa fa-home"></i><br>
                      Catalogo
            </h2>
        </button>
       </a>
      </div>

      <div class="col-6 col-md-4 col-btn my-3">
      <a href="/acquisto/getall" class="nav-link homeButton">
        <button class="btn btn-outline-dark mb-3 btn-block">
            <h2>
                <i class="fa fa-shopping-cart"></i><br>
                          Acquisti
            </h2>
        </button>
        </a>
      </div>

      <% if (user.getUsertype() == Usertype.ADMIN) { %>
        <div class="col-6 col-md-4 col-btn my-3">
        <a href="/user/getall" class="nav-link homeButton">
          <button class="btn btn-outline-dark mb-3 btn-block">
            <h2>
                <i class="fa fa-users"></i><br>
                            Utenti
            </h2>
          </button>
          </a>
        </div>

        <div class="col-6 col-md-4 col-btn">
        <a href="/agenzia/getall" class="nav-link homeButton">
          <button class="btn btn-outline-dark mb-3 btn-block">
            <h2>
                <i class="fa fa-building"></i><br>
                            Agenzie
            </h2>
          </button>
          </a>
        </div>

        <div class="col-6 col-md-4 col-btn">
        <a href="/anagrafica/getall" class="nav-link homeButton">
          <button class="btn btn-light btn-outline-dark mb-3 btn-block">
            <h2>
                <i class="fa fa-address-book"></i><br>
                            Anagrafiche
            </h2>
          </button>
          </a>
        </div>
      <% } %>

    </div>
  </div>
        <br><br>
        <br><br>
        <br><br>
        <br><br>

  <%@ include file="/css/footer.jsp" %>

</body>
</html>
