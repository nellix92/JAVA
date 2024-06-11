<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" import="it.contrader.dto.AgenziaDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Edit Agenzia</title>
</head>
<body>
     <%@ include file="/css/navbar.jsp"%>

    <div class="main container">

        <%AgenziaDTO a = (AgenziaDTO) request.getAttribute("agenziaToUpdate");%>

        <form class="create-form" action="AgenziaServlet" method="post">
            <input type="hidden" name="mode" value="update">
            <input type="hidden" name="id" value="<%=a.getId()%>">
            <h1 id="title">Modifica agenzia</h1>

            <div class="form-group">
                <label for="nome" >Nome </label>
                <input type="text" id="nome" name="nome" value="<%=a.getNome()%>" required>
            </div>
            <div class="form-group">
                <label for="citta" >Città </label>
                <input type="text" id="citta" name="citta" value="<%=a.getCitta()%>" required>
            </div>
            <div class="form-group">
                <label for="indirizzo" >Indirizzo </label>
                <input type="text" id="indirizzo" name="indirizzo"  value="<%=a.getIndirizzo()%>" required>
            </div>
            <div class="form-group">
                <label for="provincia" >Provincia </label>
                <input type="text" id="pv" name="provincia"  value="<%=a.getProvincia()%>" required>
            </div>
            <div class="form-group">
                <label for="descrizione" >Descrizione </label>
                <input type="text" id="descrizione" name="descrizione" value="<%=a.getDescrizione()%>" required>
            </div>


            <div class="button-wrapper">

                <button type="submit" >Modifica Agenzia</button>
            </div>
        </form>

    </div>

     <%@ include file="/css/footer.jsp"%>

</body>
</html>