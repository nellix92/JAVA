<%@ page import="it.contrader.dto.*, java.util.*" %>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="User Management">
        <meta name="author" content="Vittorio Valent">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <title>User Manager</title>

    </head>

    <body>
        <%@ page import="it.contrader.dto.UserDTO" %>
            <%@ page import="it.contrader.model.User.Usertype" %>

                <%@ include file="/css/navbar.jsp" %>

                    <div class="main container mt-3">
                        <% List<AgenziaDTO> list = (List<AgenziaDTO>) request.getSession().getAttribute("list");
                                UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                                it.contrader.model.User.Usertype usertype = user.getUsertype();
                                %>

                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <table class="table table-striped-columns">
                                            <thead>
                                                <tr>

                                                    <th class="text-primary-emphasis" scope="col">Nome</th>
                                                    <th class="text-primary-emphasis" scope="col">Citta</th>
                                                    <th class="text-primary-emphasis" scope="col">Indirizzo</th>
                                                    <th class="text-primary-emphasis" scope="col">Provincia</th>
                                                    <th class="text-primary-emphasis" scope="col">Descrizione</th>
                                                    <th class="text-primary-emphasis" scope="col">Admin ID</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <% for (AgenziaDTO a : list) { %>
                                                    <tr>
                                                        <td>
                                                            <%=a.getNome()%>
                                                        </td>
                                                        <td>
                                                            <%=a.getCitta()%>
                                                        </td>
                                                        <td>
                                                            <%=a.getIndirizzo()%>
                                                        </td>
                                                        <td>
                                                            <%=a.getProvincia()%>
                                                        </td>
                                                        <td>
                                                            <%=a.getDescrizione()%>
                                                        </td>
                                                        <td>
                                                            <%=a.getAdmin_id()%>
                                                        </td>

                                                        <td> <a href="/agenzia/read?id=<%=a.getId()%>"
                                                                class="text-dark">
                                                                <i class="fas fa-eye"></i>
                                                            </a>
                                                        </td>

                                                    </tr>
                                                    <% } %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                    </div>

                    <%@ include file="/css/footer.jsp" %>




    </body>

    </html>