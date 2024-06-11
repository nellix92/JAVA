<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"
    import="it.contrader.dto.AnagraficaDTO"
    import="java.util.List"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Inserimento Anagrafica</title>
</head>
<body>

    <%@ include file="/css/navbar.jsp"%>

         <div class="main container">

                <%AnagraficaDTO a = (AnagraficaDTO) request.getAttribute("anagraficaToUpdate");%>

                <form class="create-form" action="AnagraficaServlet" method="post">
                    <input type="hidden" name="mode" value="update">
                    <input type="hidden" name="id" value="<%=a.getId()%>">
                    <h1 id="title">Modifica anagrafica</h1>

                    <div class="form-group">
                        <label for="nome" >Nome </label>
                        <input type="text" id="nome" name="nome" value="<%=a.getNome()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="cognome">Città </label>
                        <input type="text" id="cognome" name="cognome" value="<%=a.getCognome()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="indirizzo">Indirizzo </label>
                        <input type="text" id="indirizzo" name="indirizzo"  value="<%=a.getIndirizzo()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="provincia">Provincia </label>
                        <input type="text" id="pv" name="provincia"  value="<%=a.getProvincia()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="data" >Data di nascita </label>
                        <input type="text" id="data" name="data" value="<%=a.getDataDiNascita()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="genere">Seleziona il tuo sesso:</label>
                        <select type="select" id="genere" name="genere" required>
                           <option value="UOMO">Uomo</option>
                           <option value="DONNA">Donna</option>
                          <option value="ALTRO">Altro</option>
                        </select><br>
                    </div>
                    <div class="form-group">
                        <label for="nazione" >Nazione </label>
                        <input type="text" id="nazione" name="nazione" value="<%=a.getNazione()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="citta" >Citta </label>
                        <input type="text" id="citta" name="citta" value="<%=a.getCitta()%>" required>
                    </div>
                    <div class="button-wrapper">

                        <button type="submit" >Modifica Anagrafica</button>
                    </div>
                </form>
         </div>


         <%@ include file="/css/footer.jsp"%>


</body>
</html>