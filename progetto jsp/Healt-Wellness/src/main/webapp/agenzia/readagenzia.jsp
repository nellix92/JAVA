<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AgenziaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
   <link href="css/style.css" rel="stylesheet"><title>Read Agenzia</title>
</head>
<body>

	 <%@ include file="/css/navbar.jsp"%>

	<div class="main container">
		<%AgenziaDTO a = (AgenziaDTO) request.getAttribute("agenzia");%>

		<div class="card">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="images/user.jpg" class="img-fluid rounded-start" alt="user avatar">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Agenzia Info</h5>

                        <p class="card-text">Nome:  <%=a.getNome()%></td>
                        <p class="card-text">Cognome:   <%=a.getCitta()%></td>
                        <p class="card-text">Indirizzo:  <%=a.getIndirizzo()%></td>
                        <p class="card-text">Provincia:  <%=a.getProvincia()%></td>
                        <p class="card-text">Admin id:  <%=a.getAdmin_id()%></td>
                        <p class="card-text">Descrizione:   <%=a.getDescrizione()%></td>
					</div>
                    <div class="container text-center">
                        <a class="btn btn-primary" href="AgenziaServlet?mode=prepare_update&id=<%=a.getId()%>" role="button"> Edit</a>
                        <a class="btn btn-danger" href="AgenziaServlet?mode=delete&id=<%=a.getId()%>" role="button"> Delete</a>
                    </div>
				</div>
			</div>
		</div>
	</div>

    <%@ include file="/css/footer.jsp"%>

</body>
</html>