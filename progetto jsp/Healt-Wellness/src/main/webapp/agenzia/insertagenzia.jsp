<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.AnagraficaDTO"
    import="it.contrader.dto.AgenziaDTO"
    import="java.util.List"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Inserimento Agenzia</title>
</head>
<body>

         <%@ include file="/css/navbar.jsp"%>


    <h1>Inserimento Agenzia</h1>
    <form class="create-form" action="AgenziaServlet?mode=insert" method="post">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required><br>

            <label for="descrizione">Descrizione:</label>
            <input type="text" id="descrizione" name="descrizione" required><br>

            <label for="provincia">Provincia:</label>
            <input type="text" id="provincia" name="provincia" required><br>

            <label for="citta">Città:</label>
            <input type="text" id="citta" name="citta" required><br>

            <label for="indirizzo">indirizzo:</label>
            <input type="text" id="indirizzo" name="indirizzo" required><br>

        <button type="submit">Inserisci Agenzia</button>
    </form>

         <%@ include file="/css/footer.jsp"%>


</body>
</html>