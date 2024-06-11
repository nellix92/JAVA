<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.util.List"
    import="it.contrader.dto.AnagraficaDTO, java.util.List, it.contrader.dto.UserDTO, it.contrader.enums.Usertype" %>

    <!DOCTYPE html>
    <html>

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>User Manager</title>

</head>

<body>

    <%@ include file="/css/navbar.jsp" %>


    <div class="main container">


        <% List<AnagraficaDTO> anagraficaList = (List<AnagraficaDTO>) request.getAttribute("anagrafiche");
                UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                it.contrader.enums.Usertype usertype = user.getUsertype();
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

    <%@ include file="/css/footer.jsp" %>

</body>
</html>