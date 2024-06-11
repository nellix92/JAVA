<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.util.List"
    import="it.contrader.dto.AgenziaDTO, java.util.List, it.contrader.dto.UserDTO, it.contrader.enums.Usertype" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <title>Home</title>

    </head>

    <body>

        <%@ include file="/css/navbar.jsp" %>

            <div class="main container">

                <% List<AgenziaDTO> list = (List<AgenziaDTO>) request.getAttribute("agenzia");
                        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                        it.contrader.enums.Usertype usertype = user.getUsertype();
                        %>

                        <h1>Welcome ${user.getUsername()}</h1>
                        <div class="container">
                            <button class="btn btn-primary" type="button"><a href="CasaServlet?mode=getall"
                                    class="nav-link homeButton" </a> Catalogo</button>
                            <button class="btn btn-primary" type="button"><a href="AcquistoServlet?mode=getAll"
                                    class="nav-link homeButton" </a> Acquisti</button>

                            <% if (usertype==it.contrader.enums.Usertype.ADMIN) { %>
                                <button class="btn btn-primary" type="button"><a href="UserServlet?mode=getall"
                                        class="nav-link homeButton" </a> Utenti</button>
                                <button class="btn btn-primary" type="button"><a href="AgenziaServlet?mode=getall"
                                        class="nav-link homeButton" </a> Agenzie</button>
                                <button class="btn btn-primary" type="button"><a href="AnagraficaServlet?mode=getall"
                                        class="nav-link homeButton" </a> Anagrafica</button>
                            <% } %>

                        </div>
            </div>

            <%@ include file="/css/footer.jsp" %>

    </body>

    </html>