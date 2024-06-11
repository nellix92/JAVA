<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="java.util.ArrayList"
    import="it.contrader.dto.AcquistoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/style.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>Read Acquisto</title>
</head>
<body>

   <%@ include file="/css/navbar.jsp"%>

    <div class="acquistiContainer mt-5">
        <% List<AcquistoDTO> acquistoList = (List<AcquistoDTO>) request.getAttribute("acquisto");%>
        <div>
            <%for (AcquistoDTO acquisto : acquistoList){%>
                <div class="card">
                  <div class="card-header">
                    Acquisto N°: <%=acquisto.getId()%>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">Nome: <%=acquisto.getNome_casa()%></h5>
                    <p class="card-text">Prezzo: <%=acquisto.getPrezzo()%></p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                  </div>
                </div>
            <%
            	}
            %>
        </div>
    </div>

     <%@ include file="/css/navbar.jsp"%>
</body>