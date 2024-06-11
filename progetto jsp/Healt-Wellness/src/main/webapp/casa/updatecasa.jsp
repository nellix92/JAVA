<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CasaDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <title>Edit Casa</title>
</head>
<body>

    <%@ include file="/css/navbar.jsp"%>

    <div class="main container">

        <%CasaDTO c = (CasaDTO) request.getAttribute("casaToUpdate");%>

        <form class="create-form" action="CasaServlet?mode=update" method="post">
                <input type="hidden" name="mode" value="update">
                <input type="hidden" name="id" value="<%=c.getId()%>">
        		<h1 id="title">Modifica Casa</h1>
        		<div class="form-group">
        			<label for="nome">Nome </label>
        			<input type="text" id="nome" name="nome" placeholder="Inserisci il nome della casa..." value="<%=c.getNome()%>" required>
        		</div>
        		<div class="form-group">
                    <label for="prezzo">Prezzo </label>
          			<input type="double" id="prezzo" name="prezzo" placeholder="Inserisci il prezzo della casa..." value="<%=c.getPrezzo()%>" required>
                </div>
                <div class="form-group">
                    <label for="indirizzo">Indirizzo </label>
                    <input type="text" id="indirizzo" name="indirizzo" placeholder="Inserisci l'indirizzo della casa..." value="<%=c.getIndirizzo()%>" required>
                </div>
                <div class="form-group">
                    <label for="metri_quadrati">Metri Quadrati </label>
                    <input type="text" id="metri_quadrati" name="metri_quadrati" placeholder="Inserisci i metri quadrati della casa..." value="<%=c.getMetri_quadrati()%>" required>
                </div>
                <div class="form-group">
                    <label for="costruita">Anno Costruzione </label>
                    <input type="text" id="costruita" name="costruita" placeholder="Inserisci l'anno di costruzione della casa..." value="<%=c.getCostruita()%>" required>
                </div>
                <div class="form-group">
                    <label for="dettagli">Dettagli </label>
                    <input type="text" id="dettagli" name="dettagli" placeholder="Inserisci i dettagli della casa..." value="<%=c.getDettagli()%>" required>
                </div>
        		<div class="form-group">

        			<label for="tipo">Tipologia</label>
        			<select id="tipo" name="tipo">
        				<option value="monolocale" <%if(c.getTipo().equals("monolocale")) {%>selected<%}%>>MONOLOCALE</option>
        				<option value="bilocale" <%if(c.getTipo().equals("bilocale")) {%>selected<%}%>>BILOCALE</option>
        				<option value="villetta" <%if(c.getTipo().equals("villetta")) {%>selected<%}%>>VILLETTA</option>
        				<option value="appartamento" <%if(c.getTipo().equals("appartamento")) {%>selected<%}%>>APPARTAMENTO</option>
        				<option value="loft" <%if(c.getTipo().equals("loft")) {%>selected<%}%>>LOFT</option>
        			</select>

        		</div>

        		<div class="form-group">
                    <label for="disponibile">Disponibile </label>
                    <input type="checkbox" id="disponibile" name="disponibile" value="true" <% if(c.isDisponibile()) { %>checked<% } %>>
                </div>

        		<div class="button-wrapper">
        			<button type="submit" >Aggiorna Modifiche Casa</button>
        		</div>
        		<div class="button-wrapper">
                    <a href="CasaServlet?mode=getall">
                        <button type="button" class="btn btn-danger">Annulla Modifiche Casa</button>
                    </a>
                </div>
        	</form>

    </div>

 <%@ include file="/css/footer.jsp"%>

</body>
</html>