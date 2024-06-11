<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="java.util.List"
    import="it.contrader.dto.AgenziaDTO, java.util.List, it.contrader.dto.UserDTO, it.contrader.enums.Usertype"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>


    <%@ include file="/css/navbar.jsp"%>


    <div class="main container">

        <%
            List<AgenziaDTO> list = (List<AgenziaDTO>) request.getAttribute("agenzie");
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            it.contrader.enums.Usertype usertype = user.getUsertype();
        %>

        <table class="table table-striped-columns">
            <thead>
                <tr>

                    <th class="text-primary-emphasis" scope="col">Nome</th>
                    <th class="text-primary-emphasis" scope="col">Città</th>
                    <th class="text-primary-emphasis" scope="col">Indirizzo</th>
                    <th class="text-primary-emphasis" scope="col">Provincia</th>
                    <th class="text-primary-emphasis" scope="col">Descrizione</th>
                    <th class="text-primary-emphasis" scope="col">Admin ID</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

                <%
                    for (AgenziaDTO a : list) {
                %>
                <tr>
                    <td><%=a.getNome()%></td>
                    <td><%=a.getCitta()%></td>
                    <td><%=a.getIndirizzo()%></td>
                    <td><%=a.getProvincia()%></td>
                    <td><%=a.getDescrizione()%></td>
                    <td><%=a.getAdmin_id()%></td>

                    <td><a href=AgenziaServlet?mode=read&id=<%=a.getId()%>> Dettaglio</a></td>

                </tr>
                <% } %>
            </tbody>
        </table>
        <div class="container">
                    <% if (usertype == it.contrader.enums.Usertype.ADMIN) { %>
                        <form class="create-form" action="AgenziaServlet?mode=insert" method="post">
                            <h1 id="title">Aggiungi Agenzia</h1>
                           <div class="form-group">
                               <label for="nome" >Nome </label>
                               <input type="text" id="nome" name="nome" placeholder="Inserisci un nome dell'agenzia" required>
                           </div>
                           <div class="form-group">
                               <label for="citta" >Città </label>
                               <input type="text" id="citta" name="citta" placeholder="Inserisci un nome di città" required>
                           </div>
                           <div class="form-group">
                               <label for="indirizzo" >Indirizzo </label>
                               <input type="text" id="indirizzo" name="indirizzo"  placeholder="Inserisci un indirizzo completo" required>
                           </div>
                           <div class="form-group">
                               <label for="provincia" >Provincia </label>
                               <input type="text" id="pv" name="provincia"  placeholder="Inserisci la provincia" required>
                           </div>
                           <div class="form-group">
                               <label for="descrizione" >Descrizione </label>
                               <input type="text" id="descrizione" name="descrizione" placeholder="Inserisci una descrizione dell'agenzia" required>
                           </div>
                           <div class="button-wrapper">
                               <button type="submit" >Crea Agenzia</button>
                           </div>
                        </form>
                    <% } %>
                </div>

    </div>

<%@ include file="/css/footer.jsp"%>


</body>
</html>