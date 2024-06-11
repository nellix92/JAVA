<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.util.List"
    import="java.util.ArrayList" import="it.contrader.dto.AcquistoDTO,  java.util.List, it.contrader.dto.UserDTO, it.contrader.enums.Usertype" %>

   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
   <link href="css/style.css" rel="stylesheet">
   <title>User Manager</title>

   </head>

    <body>

        <%@ include file="/css/navbar.jsp" %>
            <% List<AcquistoDTO> list = (List<AcquistoDTO>) request.getAttribute("acquisto");
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            it.contrader.enums.Usertype usertype = user.getUsertype();
            %>


                <div class="main container">
                    <table class="table table-striped-columns ">
                        <thead>
                            <tr>
                                <th class="text-primary-emphasis" scope="col"> #</th>
                                <th class="text-primary-emphasis" scope="col"> Utente</th>
                                <th class="text-primary-emphasis" scope="col"> Prezzo</th>
                                <th class="text-primary-emphasis" scope="col"> Casa Id</th>
                                <th class="text-primary-emphasis" scope="col"> Anagrafica Id</th>

                            </tr>
                        </thead>
                        <tbody>

                            <% for (AcquistoDTO a : list) { %>
                                <tr>
                                    <th scope="row">
                                        <%=a.getId()%>
                                    </th>
                                    <td>
                                        <%=a.getNome_casa()%>
                                    </td>
                                    <td>
                                        <%=a.getPrezzo()%>
                                    </td>
                                    <td>
                                        <%=a.getCasa_id()%>
                                    </td>
                                    <td>
                                        <%=a.getAnagrafica_id()%>
                                    </td>

                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                </div>
                <%@ include file="/css/footer.jsp" %>

    </body>