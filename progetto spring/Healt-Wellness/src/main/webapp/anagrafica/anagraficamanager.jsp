<%@ page language="java"
import="java.util.List"
import="it.contrader.dto.AnagraficaDTO"
import="java.util.List"
import="it.contrader.dto.UserDTO"
import="it.contrader.model.User.Usertype"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<title>Anagrafica Manager</title>

</head>

<body>

    <%@ include file="../css/navbar.jsp" %>

    <div class="main container">

        <% List<AnagraficaDTO> anagraficaList = (List<AnagraficaDTO>) request.getSession().getAttribute("list");
           UserDTO user = (UserDTO) request.getSession().getAttribute("user");
           it.contrader.model.User.Usertype usertype = user.getUsertype();
        %>

            <table class="table table-striped-columns">
                <thead>
                    <tr>
                        <th class="text-primary-emphasis" scope="col">Nome</th>
                        <th class="text-primary-emphasis" scope="col">Cognome</th>
                        <th class="text-primary-emphasis" scope="col">Email</th>
                        <th class="text-primary-emphasis" scope="col">Data di Nascita</th>
                        <th class="text-primary-emphasis" scope="col">Genere</th>
                        <th class="text-primary-emphasis" scope="col">Nazione</th>
                        <th class="text-primary-emphasis" scope="col">Provincia</th>
                        <th class="text-primary-emphasis" scope="col">Città</th>
                        <th class="text-primary-emphasis" scope="col">Indirizzo</th>
                    </tr>
                </thead>
                <tbody>

                    <% for (AnagraficaDTO anagrafica : anagraficaList) { %>
                        <tr>
                            <td>
                                <%= anagrafica.getNome() %>
                            </td>
                            <td>
                                <%= anagrafica.getCognome() %>
                            </td>
                            <td>
                                <%= anagrafica.getEmail() %>
                            </td>
                            <td>
                                <%= anagrafica.getDataDiNascita() %>
                            </td>
                            <td>
                                <%= anagrafica.getGenere() %>
                            </td>
                            <td>
                                <%= anagrafica.getNazione() %>
                            </td>
                            <td>
                                <%= anagrafica.getProvincia() %>
                            </td>
                            <td>
                                <%= anagrafica.getCitta() %>
                            </td>
                            <td>
                                <%= anagrafica.getIndirizzo() %>
                            </td>
                        </tr>
                        <% } %>
                </tbody>
            </table>
    </div>

    <%@ include file="../css/footer.jsp" %>

</body>
</html>