<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO, it.contrader.dto.UserDTO, it.contrader.enums.Usertype, it.contrader.dto.AnagraficaDTO, java.util.List, java.util.ArrayList "
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="css/style.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Read User</title>
</head>
<body>
	 <%@ include file="/css/navbar.jsp"%>



	<div class="main container">
		<%
		UserDTO u = (UserDTO) request.getAttribute("user");
        it.contrader.enums.Usertype usertype = u.getUsertype();
 		%>
		<div class="card">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="images/user.jpg" class="img-fluid rounded-start" alt="user avatar">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">User Info</h5>
						<p class="card-text">Username: <%=u.getUsername()%></p>
						<p class="card-text">Password: <%=u.getPassword()%></p>
					</div>
				</div>
			</div>
		</div>

            <div class="container text-center">
                <a class="btn btn-primary" href="UserServlet?mode=prepare_update&id=<%=u.getId()%>" role="button"> Edit</a>
                <a class="btn btn-danger" href="UserServlet?mode=delete&id=<%=u.getId()%>" role="button"> Delete</a>
            </div>
	</div>


	 <% AnagraficaDTO anagrafica= (AnagraficaDTO) request.getAttribute("anagrafica");%>

        <h1>Dettagli Anagrafica</h1>

        <div class="card mb-3">
            <div class="card-body">
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
                <p class="card-text">userId: <%= anagrafica.getUserId() %></p>

                    <div class="container text-center">
                        <a class="btn btn-primary" href="AnagraficaServlet?mode=prepare_update&id=<%=anagrafica.getId()%>" role="button"> Edit</a>
                    </div>
            </div>
        </div>



     <%@ include file="/css/footer.jsp"%>
</body>
</html>