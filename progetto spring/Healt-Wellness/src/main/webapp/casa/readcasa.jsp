<%@ page import="it.contrader.dto.*, java.util.*"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Casa Read">
    <meta name="author" content="Vittorio Valent">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">    <link href="/css/style.css" rel="stylesheet">
    <title>Casa Read</title>
</head>
    <body>
        <%@ include file="/css/navbar.jsp"%>
        <div class="container mt-4">
            <% CasaDTO c = (CasaDTO) request.getSession().getAttribute("dto");
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            it.contrader.model.User.Usertype usertype = user.getUsertype();
            System.out.println("Usertype in session: " + usertype);
            %>

            <a class="btn btn-dark text-white mb-3" href="/casa/getall">Torna al catalogo  <i class="fas fa-list"></i></a>

            <div class="card">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="https://us.123rf.com/450wm/vectorplus/vectorplus1602/vectorplus160200320/51898385-home-icons-for-graphic-design-and-internet-sites-vector-illustration.jpg?ver=6" class="img-fluid rounded-start" alt="casa avatar">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h4 class="card-title text-center"><strong>Casa Info</strong></h5>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><strong>Nome:</strong> <%=c.getNome()%></li>
                                <li class="list-group-item"><strong>Prezzo:</strong> <%=c.getPrezzo()%></li>
                                <li class="list-group-item"><strong>Indirizzo:</strong> <%=c.getIndirizzo()%></li>
                                <li class="list-group-item"><strong>Metratura:</strong> <%=c.getMetratura()%></li>
                                <li class="list-group-item"><strong>Anno di costruzione:</strong> <%=c.getCostruita()%></li>
                                <li class="list-group-item"><strong>Dettagli:</strong> <%=c.getDettagli()%></li>
                                <li class="list-group-item"><strong>Tipo:</strong> <%=c.getTipo()%></li>
                            </ul>
                            <div class="container text-center mt-3">
                                <% if (usertype==it.contrader.model.User.Usertype.ADMIN) { %>
                                    <a class="btn btn-dark text-white" href="/casa/preupdate?id=<%=c.getId()%>"> <i class="fas fa-edit"></i></a>
                                    <a class="btn btn-danger text-white" href="/casa/delete?id=<%=c.getId()%>"> <i class="fas fa-trash"></i></a>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
