<%@ page import="it.contrader.dto.*, java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">  <title>User Manager</title>

</head>

<body>
    <%@ include file="/css/navbar.jsp"%>

    <div class="main container">
       <%AgenziaDTO a = (AgenziaDTO) request.getSession().getAttribute("dto");%>

       <div class="card mx-auto mb-5">
          <div class="row g-0 mt-3">
             <div class="col-md-4">
                <img src="/images/user.jpg" class="img-fluid rounded-start" alt="user avatar">
             </div>
             <div class="col-md-8">
                <div class="card-body">
                   <h5 class="card-title">Agenzia Info</h5>

                        <p class="card-text">Nome:  <%=a.getNome()%></td>
                        <p class="card-text">Cognome:   <%=a.getCitta()%></td>
                        <p class="card-text">Indirizzo:  <%=a.getIndirizzo()%></td>
                        <p class="card-text">Provincia:  <%=a.getProvincia()%></td>
                        <p class="card-text">Admin id:  <%=a.getAdmin_id()%></td>
                        <p class="card-text">Descrizione:   <%=a.getDescrizione()%></td>
                </div>
                    <div class="card-body text-center">
                        <a class="btn btn-primary" href="/agenzia/update?id=<%=a.getId()%>" role="button">
                            <i class="fas fa-edit"></i></a>

                    </div>
             </div>
          </div>
       </div>
    </div>

    <%@ include file="/css/footer.jsp"%>
</body>
</html>
