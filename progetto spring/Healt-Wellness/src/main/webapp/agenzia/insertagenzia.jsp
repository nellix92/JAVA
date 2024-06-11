<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"
    import="it.contrader.dto.AnagraficaDTO"
    import="it.contrader.dto.AgenziaDTO"
    import="java.util.List"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>User Manager</title>

<style>
.create-form {
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.create-form label {
    display: block;
    margin-bottom: 5px;
}

.create-form input[type="text"],
.create-form input[type="date"],
.create-form select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.1);
}

.create-form input[type="text"]:focus,
.create-form input[type="date"]:focus,
.create-form select:focus {
    border-color: #444;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
}

.create-form button {
    background-color: #444;
    color: #fff;
    border: 1px solid #444;
    border-radius: 5px;
    padding: 10px 20px;
    margin-top: 15px;
    display: block;
    width: 100%;
    cursor: pointer;
}

.create-form button:hover {
    background-color: #333;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>


    <div class="container text-center">
        <h1>Inserimento Agenzia</h1>
        <form class="create-form" action="/agenzia/insert" method="post">

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
    </div>




</body>
</html>
