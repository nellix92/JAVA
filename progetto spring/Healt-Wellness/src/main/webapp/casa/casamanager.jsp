<%@ page import="it.contrader.dto.*" import="java.util.*" import="it.contrader.model.Casa.Tipo"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Casa Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<title>Casa Manager</title>
</head>
<body>
<%@ include file="/css/navbar.jsp" %>
<div class="container">
     <% List<CasaDTO> list = (List<CasaDTO>) request.getSession().getAttribute("list");
    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
    it.contrader.model.User.Usertype usertype = user.getUsertype();
    System.out.println("Usertype in session: " + usertype);
    %>
    <div class="row container mt-3">
        <div class="col">
            <h2 class="text-center">Filtra le Case</h2>
            <form action="/casa/search" method="get">
                <input type="hidden" name="mode" value="filtri">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" class="form-control">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="prezzo">Prezzo:</label>
                        <input type="text" id="prezzo" name="prezzo" class="form-control">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="metratura">Metri Quadrati:</label>
                        <input type="text" id="metratura" name="metratura" class="form-control">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="costruita">Anno Costruzione:</label>
                        <input type="text" id="costruita" name="costruita" class="form-control">
                    </div>
                </div>
                <button type="submit" class="btn btn-dark">Cerca <i class="fa fa-search"></i></button>
                <% String errorMessage = (String) request.getAttribute("errorMessage");
                   if(errorMessage != null && !errorMessage.isEmpty()) { %>
                    <div style="color: red;">
                        <%= errorMessage %>
                    </div>
                <% } %>
            </form>
        </div>
    </div>
    <div class="row container text-center mt-3">
        <div class="col">
            <h2>Elenco Case</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Prezzo</th>
                        <th scope="col">Indirizzo</th>
                        <th scope="col">Dettagli</th>
                        <th scope="col">Azione</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (CasaDTO c : list) {
                        if(c.isDisponibile()){ %>
                            <tr>
                                <td><%=c.getNome()%></td>
                                <td><%=c.getPrezzo()%></td>
                                <td><%=c.getIndirizzo()%></td>
                                <td>  <a href="/casa/read?id=<%=c.getId()%>" class="text-dark">
                                        <i class="fas fa-eye"></i>
                                    </a>
                                </td>
                                <td>
                                    <form action="/acquisto/insert" method="post">
                                        <input type="hidden" name="houseId" value="<%=c.getId()%>">
                                        <button type="submit" class="btn btn-success">Compra <i class="fa fa-shopping-cart"></i></button>
                                    </form>
                                </td>
                            </tr>
                        <% } } %>
                </tbody>
            </table>
        </div>
    </div>
    <% if (usertype==it.contrader.model.User.Usertype.ADMIN) { %>
        <div class="row container text-center mt-3 mb-5">
            <div class="col mx-auto">
                <h2>Aggiungi Casa</h2>
                <form action="/casa/insert" method="post">
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="prezzo">Prezzo:</label>
                        <input type="number" id="prezzo" name="prezzo" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="indirizzo">Indirizzo:</label>
                        <input type="text" id="indirizzo" name="indirizzo" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="metratura">Metri Quadrati:</label>
                        <input type="number" id="metratura" name="metratura" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="costruita">Anno Costruzione:</label>
                        <input type="number" id="costruita" name="costruita" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="dettagli">Dettagli:</label>
                        <input type="text" id="dettagli" name="dettagli" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipologia:</label>
                        <select id="tipo" name="tipo" class="form-control">
                            <option value="monolocale">MONOLOCALE</option>
                            <option value="bilocale">BILOCALE</option>
                            <option value="loft">LOFT</option>
                            <option value="villa">VILLA</option>
                            <option value="appartamento">APPARTAMENTO</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-dark">Crea Casa </button>
                </form>
            </div>
        </div>
    <% } %>
</div>
<%@ include file="/css/footer.jsp" %>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
