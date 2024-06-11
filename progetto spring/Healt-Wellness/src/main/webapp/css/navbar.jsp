<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Navbar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3"> <div class="container-fluid">
    <a class="navbar-brand" href="/home.jsp">
      <img src="/images/logo.houseity.svg" alt="Logo" width="90" class="d-inline-block align-text-top" style="border: 1px solid white; border-radius: 10%; padding: 10%; background-color: white;">

    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent"> <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link text-white" href="/home.jsp">Home</a>  </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="/user/profilo">Profilo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="/user/logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>



</body>
</html>
