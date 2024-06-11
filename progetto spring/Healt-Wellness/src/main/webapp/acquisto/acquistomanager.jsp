<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.util.List"
    import="java.util.ArrayList" import="it.contrader.dto.*,  java.util.List, it.contrader.model.User.Usertype"%>

   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="utf-8">
   <meta name="viewport"
   	content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="User Management">
   <meta name="author" content="Vittorio Valent">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <title>Acquisto Manager</title>

   </head>

    <body>

        <%@ include file="../css/navbar.jsp" %>
            <% List<AcquistoDTO> list = (List<AcquistoDTO>) request.getSession().getAttribute("list");
               List<AcquistoDTO> listaAcquisti = (List<AcquistoDTO>) request.getSession().getAttribute("listaAcquisti");
               List<CasaDTO> listaVendite = (List<CasaDTO>) request.getSession().getAttribute("listaVendite");
               List<CasaDTO> casaList = (List<CasaDTO>) request.getSession().getAttribute("casaList");
               List<AnagraficaDTO> anagraficaList = (List<AnagraficaDTO>) request.getSession().getAttribute("anagraficaList");
               List<AgenziaDTO> agenziaList = (List<AgenziaDTO>) request.getSession().getAttribute("agenziaList");
               UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            it.contrader.model.User.Usertype usertype = user.getUsertype();
            %>

                <div class="main container mb-5 mt-3">
            <a href="/casa/getall" class="btn btn-dark mb-3">Torna al catalogo</a>
                    <table class="table table-striped-columns ">
                        <thead>
                            <tr>
                                <th class="text-primary-emphasis" scope="col"> Prezzo</th>
                                <th class="text-primary-emphasis" scope="col"> Data acquisto</th>
                                <th class="text-primary-emphasis" scope="col"> Nome</th>
                                <th class="text-primary-emphasis" scope="col"> Utente</th>
                                <th></th>
                                <th></th>

                            </tr>
                        </thead>
                        <tbody>

                            <%  if(user.getUsertype() == Usertype.USER){
                                for (AcquistoDTO a : listaAcquisti) {
                                %>
                                <tr>
                                    <td>
                                        <%=a.getPrezzo()%>
                                    </td>
                                    <td>
                                        <%=a.getData()%>
                                    </td>
                                    <td>
                                        <%for(CasaDTO c : casaList){
                                        if(c.getId() == a.getCasa_id()){%>
                                            <%=c.getNome()%>
                                        <%}}%>
                                    </td>
                                    <td>
                                        <%for(AnagraficaDTO anagrafica : anagraficaList){
                                        if(anagrafica.getId() == a.getAnagrafica_id()){%>
                                            <%=anagrafica.getNome()%> <%=anagrafica.getCognome()%>
                                        <%}}%>
                                    </td>
                                    <td>
                                        <a href="/acquisto/read?id=<%=a.getId()%>">Dettaglio</a>
                                    </td>
                                    <td>
                                        <a href="/acquisto/delete?id=<%=a.getId()%>">Cancella</a>
                                    </td>
                                </tr>
                                <% }} else if(user.getUsertype() == Usertype.ADMIN) {
                                    for(AcquistoDTO a : list){
                                    for(CasaDTO c : listaVendite){
                                    if(a.getCasa_id() == c.getId()){
                                    %>
                                    <tr>
                                        <td>
                                            <%=a.getPrezzo()%>
                                        </td>
                                        <td>
                                            <%=a.getData()%>
                                        </td>
                                        <td>
                                            <%=c.getNome()%>
                                        </td>
                                        <td>
                                            <%for(AnagraficaDTO anagrafica : anagraficaList){
                                            if(anagrafica.getId() == a.getAnagrafica_id()){%>
                                                <%=anagrafica.getNome()%> <%=anagrafica.getCognome()%>
                                            <%}}%>
                                        </td>
                                          <td>
                                             <a href="/acquisto/read?id=<%=a.getId()%>" class="text-dark">
                                                 <i class="fas fa-eye"></i>
                                             </a>
                                         </td>
                                         <td>
                                             <a href="/acquisto/delete?id=<%=a.getId()%>" class="text-dark">
                                                 <i class="fas fa-trash-alt"></i>
                                             </a>
                                         </td>
                                    </tr>
                                <% }}}
                                } %>
                        </tbody>
                    </table>
                </div>
                <%@ include file="../css/footer.jsp" %>

    </body>