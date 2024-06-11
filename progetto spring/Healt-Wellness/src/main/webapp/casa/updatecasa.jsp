<%@ page import="it.contrader.dto.*" import="java.util.*" import="it.contrader.model.Casa.Tipo"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Casa Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="/css/style.css" rel="stylesheet">
<title>Casa Update</title>
</head>
<body>
    <%@ include file="/css/navbar.jsp" %>

    <div class="container mt-4">
        <% CasaDTO c = (CasaDTO) request.getSession().getAttribute("dto"); %>
        <div class="d-flex justify-content-center">
            <form class="create-form" action="/casa/update" method="post">
                <input type="hidden" name="mode" value="update">
                <input type="hidden" name="id" value="<%=c.getId()%>">
                <h1 class="mb-4">Modifica Casa</h1>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" id="nome" name="nome" class="form-control" placeholder="Inserisci il nome della casa..." value="<%=c.getNome()%>" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="prezzo">Prezzo</label>
                        <input type="number" id="prezzo" name="prezzo" class="form-control" placeholder="Inserisci il prezzo della casa..." value="<%=c.getPrezzo()%>" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="indirizzo">Indirizzo</label>
                        <input type="text" id="indirizzo" name="indirizzo" class="form-control" placeholder="Inserisci l'indirizzo della casa..." value="<%=c.getIndirizzo()%>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="metratura">Metri Quadrati</label>
                        <input type="number" id="metratura" name="metratura" class="form-control" placeholder="Inserisci i metri quadrati della casa..." value="<%=c.getMetratura()%>" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="costruita">Anno Costruzione</label>
                        <input type="number" id="costruita" name="costruita" class="form-control" placeholder="Inserisci l'anno di costruzione della casa..." value="<%=c.getCostruita()%>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="dettagli">Dettagli</label>
                    <input type="text" id="dettagli" name="dettagli" class="form-control" placeholder="Inserisci i dettagli della casa..." value="<%=c.getDettagli()%>" required>
                </div>
                <div class="form-group">
                    <label for="tipo">Tipologia</label>
                    <select id="tipo" name="tipo" class="form-control">
                        <option value="monolocale" <%if(c.getTipo().equals("monolocale")) {%>selected<%}%>>MONOLOCALE</option>
                        <option value="bilocale" <%if(c.getTipo().equals("bilocale")) {%>selected<%}%>>BILOCALE</option>
                        <option value="villa" <%if(c.getTipo().equals("villa")) {%>selected<%}%>>VILLA</option>
                        <option value="appartamento" <%if(c.getTipo().equals("appartamento")) {%>selected<%}%>>APPARTAMENTO</option>
                        <option value="loft" <%if(c.getTipo().equals("loft")) {%>selected<%}%>>LOFT</option>
                    </select>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" id="disponibile" name="disponibile" class="form-check-input" <% if(c.isDisponibile()) { %>checked<% } %>>
                    <label class="form-check-label" for="disponibile">Disponibile</label>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-dark text-white my-3">Aggiorna Modifiche Casa</button>
                    <a href="/casa/getall" class="btn btn-danger text-white">Annulla Modifiche Casa</a>
                </div>
            </form>
        </div>
    </div>

    <%@ include file="/css/footer.jsp" %>
</body>
</html>
