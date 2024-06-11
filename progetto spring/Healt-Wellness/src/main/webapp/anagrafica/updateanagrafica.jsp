er
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"
    import="it.contrader.dto.AnagraficaDTO"
    import="it.contrader.dto.UserDTO"
    import="java.util.List"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="User Read">
    <meta name="author" content="Vittorio Valent">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Anagrafica User</title>
</head>
<body>
    <%@ include file="/css/navbar.jsp"%>

    <div class="container text-center mt-4 mx-auto">
        <% AnagraficaDTO a = (AnagraficaDTO) request.getSession().getAttribute("anagrafica"); %>
        <div class="card mx-auto mb-5" style="max-width: 500px;">
            <div class="card-header text-white bg-dark ">
                Modifica Anagrafica
            </div>
            <div class="card-body text-center">
                <form class="create-form" action="/anagrafica/update" method="post">
                    <input type="hidden" name="mode" value="update">
                    <input type="hidden" name="id" value="<%= a.getId() %>">

                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="<%= a.getNome() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="cognome">Cognome</label>
                        <input type="text" class="form-control" id="cognome" name="cognome" value="<%= a.getCognome() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="data">Data di nascita</label>
                        <input type="date" class="form-control" id="data" name="datadinascita" value="<%= a.getDataDiNascita() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="genere">Seleziona il tuo sesso:</label>
                        <select class="form-control" id="genere" name="genere" required>
                            <option value="UOMO">Uomo</option>
                            <option value="DONNA">Donna</option>
                            <option value="ALTRO">Altro</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="<%= a.getEmail() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="indirizzo">Indirizzo</label>
                        <input type="text" class="form-control" id="indirizzo" name="indirizzo" value="<%= a.getIndirizzo() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="nazione">Nazione</label>
                        <input type="text" class="form-control" id="nazione" name="nazione" value="<%= a.getNazione() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="provincia">Provincia</label>
                        <input type="text" class="form-control" id="pv" name="provincia" value="<%= a.getProvincia() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="citta">Citta</label>
                        <input type="text" class="form-control" id="citta" name="citta" value="<%= a.getCitta() %>" required>
                    </div>

                    <div class="button-wrapper text-center">
                        <button type="submit" class="btn btn-dark">Modifica Anagrafica</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="/css/footer.jsp"%>
</body>
</html>
