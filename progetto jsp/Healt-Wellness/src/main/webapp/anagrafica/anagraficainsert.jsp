<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
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


    <h1>Inserimento Anagrafica</h1>
    <form class="create-form" action="AnagraficaServlet?mode=insert" method="post">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required><br>

            <label for="cognome">Cognome:</label>
            <input type="text" id="cognome" name="cognome" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <label for="datadinascita">Data di Nascita:</label>
            <input type="text" id="datadinascita" name="datadinascita" required><br>

            <label for="genere">Seleziona il tuo sesso:</label>
            <select type="select" id="genere" name="genere" required>
                <option value="UOMO">Uomo</option>
                <option value="DONNA">Donna</option>
                <option value="ALTRO">Altro</option>
            </select><br>

            <label for="nazione">Nazione:</label>
            <input type="text" id="nazione" name="nazione" required><br>

            <label for="provincia">Provincia:</label>
            <input type="text" id="provincia" name="provincia" required><br>

            <label for="citta">Citta: </label>
            <input type="text" id="citta" name="citta" required><br>

            <label for="indirizzo">Indirizzo: </label>
            <input type="text" id="indirizzo" name="indirizzo" required><br>

        <button type="submit">Inserisci</button>
    </form>

         <%@ include file="/css/footer.jsp"%>


</body>
</html>