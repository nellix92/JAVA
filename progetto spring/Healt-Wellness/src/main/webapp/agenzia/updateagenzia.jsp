<%@ page import="it.contrader.dto.*, java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>User Manager</title>

</head>
<body>
     <%@ include file="/css/navbar.jsp"%>

    <div class="main container mt-3">

        <%
            AgenziaDTO a = (AgenziaDTO) request.getSession().getAttribute("dto");
        %>

        <div class="card mx-auto" style="max-width: 500px;">  <div class="card-header">
                <h5 class="card-title">Modifica agenzia</h5>
            </div>
            <div class="card-body">
                <form class="create-form" action="/agenzia/update" method="post">
                    <input type="hidden" name="mode" value="update">
                    <input type="hidden" name="id" value="<%=a.getId()%>">

                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="<%=a.getNome()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="citta">Città</label>
                        <input type="text" class="form-control" id="citta" name="citta" value="<%=a.getCitta()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="indirizzo">Indirizzo</label>
                        <input type="text" class="form-control" id="indirizzo" name="indirizzo"  value="<%=a.getIndirizzo()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="provincia">Provincia</label>
                        <input type="text" class="form-control" id="pv" name="provincia"  value="<%=a.getProvincia()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="descrizione">Descrizione</label>
                        <input type="text" class="form-control" id="descrizione" name="descrizione" value="<%=a.getDescrizione()%>" required>
                    </div>

                    <div class="button-wrapper text-center">
                        <button type="submit" class="btn btn-primary">Modifica Agenzia</button>
                    </div>
                </form>
            </div>
        </div>

    </div>

     <%@ include file="/css/footer.jsp"%>

</body>
</html>
