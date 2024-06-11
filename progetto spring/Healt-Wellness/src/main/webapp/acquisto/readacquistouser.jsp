<%@ page import="java.util.List"
    import="java.util.ArrayList"
    import="it.contrader.dto.*"%>
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

</head>
<body>

   <%@ include file="/css/navbar.jsp"%>

    <div class="mt-5 mb-5 mx-auto shadow rounded border border-light container">
        <%
           AcquistoDTO acquisto = (AcquistoDTO) request.getSession().getAttribute("acquistoDTO");
           List<CasaDTO> casaList = (List<CasaDTO>) request.getSession().getAttribute("casaList");
           List<AnagraficaDTO> anagraficaList = (List<AnagraficaDTO>) request.getSession().getAttribute("anagraficaList");
           UserDTO user = (UserDTO) request.getSession().getAttribute("user");
           CasaDTO c = new CasaDTO();
           AnagraficaDTO a = new AnagraficaDTO();
           for(CasaDTO casa : casaList){
                if(casa.getId() == acquisto.getCasa_id()){
                    c = casa;
                }
           }
           for(AnagraficaDTO anagrafica : anagraficaList){
                if(anagrafica.getId() == acquisto.getAnagrafica_id()){
                    a = anagrafica;
                }
           }
        %>
        <div class="card container text-center">
          <div class="card-header bg-dark text-white">
            Acquisto N: <%=acquisto.getId()%>
          </div>
          <div class="card-body">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">
                <p class="">
                  Cliente: <%=a.getNome()%> <%=a.getCognome()%>
                </p>
              </li>
              <li class="list-group-item">
                <p class="">
                  Casa: <%=c.getNome()%>
                </p>
              </li>
              <li class="list-group-item">
                <p class="">
                  Prezzo: <%=c.getPrezzo()%>
                </p>
              </li>
              <li class="list-group-item">
                <p>
                  Metratura: <%=c.getMetratura()%> mq
                </p>
              </li>
              <li class="list-group-item">
                <p>
                  Indirizzo: <%=c.getIndirizzo()%>
                </p>
              </li>
            </ul>
          </div>
        </div>
    </div>

    <%@ include file="/css/footer.jsp"%>
</body>

</html>