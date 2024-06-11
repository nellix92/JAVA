<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO, it.contrader.dto.AnagraficaDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">  <title>Read User</title>
</head>
<body>
    <%@ include file="../css/navbar.jsp"%>

    <br> <br>

    <div class="main container text-center">
       <%
          UserDTO u = (UserDTO) request.getSession().getAttribute("dto");
       %>

       <table class="table table-bordered table-hover">  <thead>
             <tr>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Usertype</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
             </tr>
          </thead>
          <tbody>
             <tr>
                <td><%=u.getUsername()%></td>
                <td><%=u.getPassword()%></td>
                <td><%=u.getUsertype()%></td>
                <td>  <a href="/user/preupdate?&id=<%=u.getId()%>" class="text-dark">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
                <td>  <a href="/user/delete?&id=<%=u.getId()%>" class="text-dark">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
             </tr>
          </tbody>
       </table>
    </div>

    <div class="main container">
     <% AnagraficaDTO anagrafica= (AnagraficaDTO) request.getSession().getAttribute("anagrafica");%>

        <h1>Dettagli Anagrafica</h1>

        <div class="card mb-3">
            <div class="card-body text-center">
                <h5 class="card-title">Informazioni di <%= anagrafica.getNome() %></h5>

                <p class="card-text">nome: <%= anagrafica.getNome() %></p>
                <p class="card-text">cognome: <%= anagrafica.getCognome() %></p>
                <p class="card-text">email: <%= anagrafica.getEmail() %></p>
                <p class="card-text">dataDiNascita: <%= anagrafica.getDataDiNascita() %></p>
                <p class="card-text">genere: <%= anagrafica.getGenere() %></p>
                <p class="card-text">nazione: <%= anagrafica.getNazione() %></p>
                <p class="card-text">provincia: <%= anagrafica.getProvincia() %></p>
                <p class="card-text">citta: <%= anagrafica.getCitta() %></p>
                <p class="card-text">indirizzo: <%= anagrafica.getIndirizzo() %></p>

                <div class="container text-center">
                    <a class="btn btn-dark" href="/anagrafica/preupdate?&id=<%=anagrafica.getId()%>" role="button">
                        <i class="fas fa-edit"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../css/footer.jsp"%>

</body>
</html>
