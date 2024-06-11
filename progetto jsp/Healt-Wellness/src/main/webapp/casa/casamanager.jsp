<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" import="java.util.List"
    import="java.util.List, it.contrader.dto.*, it.contrader.enums.Usertype" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <title>Casa Manager</title>

    </head>

    <body>
        <%@ include file="/css/navbar.jsp" %>
            <div class="main container">
                <% List<CasaDTO> list = (List<CasaDTO>) request.getAttribute("casa");
                        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                        it.contrader.enums.Usertype usertype = user.getUsertype();
                        System.out.println("Usertype in session: " + usertype);
                        %>

                        <div class="search-form">
                            <h2 class="text-center">FILTRA LE CASE</h2>
                            <form action="CasaServlet" method="get" class="d-flex col-12">
                                <input type="hidden" name="mode" value="filtri">

                                <div class="form-group mx-2">
                                    <label for="cercaNome">Nome:</label>
                                    <input type="text" id="cercaNome" name="cercaNome">
                                </div>
                                <div class="form-group mx-2">
                                    <label for="cercaPrezzocercaPrezzo">Prezzo:</label>
                                    <input type="text" id="cercaPrezzo" name="cercaPrezzo">
                                </div>
                                <div class="form-group mx-2">
                                    <label for="cercaMetri">Metri Quadrati:</label>
                                    <input type="text" id="cercaMetri" name="cercaMetri">
                                </div>
                                <div class="form-group mx-2">
                                    <label for="cercaAnno">Anno Costruzione:</label>
                                    <input type="text" id="cercaAnno" name="cercaAnno">
                                </div>
                                <div class="button-wrapper">
                                    <button type="submit">Cerca</button>
                                </div>
                            </form>
                        </div>

                        <table class="table rounded table-striped-columns">
                            <thead>
                                <tr>
                                    <th class="text-primary-emphasis" scope="col">ID</th>
                                    <th class="text-primary-emphasis" scope="col">ID AGENZIA</th>
                                    <th class="text-primary-emphasis" scope="col">Nome</th>
                                    <th class="text-primary-emphasis" scope="col">Prezzo</th>
                                    <th class="text-primary-emphasis" scope="col">Indirizzo</th>
                                    <th class="text-primary-emphasis" scope="col">Metri Quadrati</th>
                                    <th class="text-primary-emphasis" scope="col">Anno Costruzione</th>
                                    <th class="text-primary-emphasis" scope="col">Dettagli</th>
                                    <th class="text-primary-emphasis" scope="col">Tipo</th>
                                <% if (usertype==it.contrader.enums.Usertype.ADMIN) { %>
                                   <th></th>
                                   <th></th>
                                <% } %>
                                    <th></th>

                                </tr>
                            </thead>
                            <tbody>
                                <% for (CasaDTO c : list) {
                                    if(c.isDisponibile()){
                                %>
                                    <tr>
                                        <th scope="row">
                                            <a href=CasaServlet?mode=read&id=<%=c.getId()%>><%=c.getId()%></a>
                                        </th>
                                        <td>
                                            <%=c.getId_agenzia()%>
                                        </td>
                                        <td>
                                            <%=c.getNome()%>
                                        </td>
                                        <td>
                                            <%=c.getPrezzo()%>
                                        </td>
                                        <td>
                                            <%=c.getIndirizzo()%>
                                        </td>
                                        <td>
                                            <%=c.getMetri_quadrati()%>
                                        </td>
                                        <td>
                                            <%=c.getCostruita()%>
                                        </td>
                                        <td>
                                            <%=c.getDettagli()%>
                                        </td>
                                        <td>
                                            <%=c.getTipo()%>
                                        </td>
                                    <% if (usertype==it.contrader.enums.Usertype.ADMIN) { %>

                                        <td><a href=CasaServlet?mode=prepare_update&id=<%=c.getId()%>>Edit</a>
                                        </td>
                                        <td><a href=CasaServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
                                        </td>
                                    <% } %>
                                        <td>
                                            <form class="create-form" style="width: 100%;" action="AcquistoServlet" method="post">
                                                <input type="hidden" name="mode" value="insert">
                                                <input type="hidden" name="houseId" value="<%=c.getId()%>">
                                                <button type="submit">Compra</button>
                                            </form>
                                        </td>
                                    </tr>
                                <% } }%>
                            </tbody>
                        </table>

                        <% if (usertype==it.contrader.enums.Usertype.ADMIN) { %>

                            <form class="create-form" action="CasaServlet?mode=insert" method="post">
                                <h1 id="title">Aggiungi Casa</h1>

                                <div class="form-group">
                                    <label for="nome">Nome </label>
                                    <input type="text" id="nome" name="nome"
                                        placeholder="Inserisci il nome della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="prezzo">Prezzo </label>
                                    <input type="double" id="prezzo" name="prezzo"
                                        placeholder="Inserisci il prezzo della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="indirizzo">Indirizzo </label>
                                    <input type="text" id="indirizzo" name="indirizzo"
                                        placeholder="Inserisci l'indirizzo della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="metri_quadrati">Metri Quadrati </label>
                                    <input type="text" id="metri_quadrati" name="metri_quadrati"
                                        placeholder="Inserisci i metri quadrati della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="costruita">Anno Costruzione </label>
                                    <input type="text" id="costruita" name="costruita"
                                        placeholder="Inserisci l'anno di costruzione della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="dettagli">Dettagli </label>
                                    <input type="text" id="dettagli" name="dettagli"
                                        placeholder="Inserisci i dettagli della casa..." required>
                                </div>
                                <div class="form-group">
                                    <label for="tipo">Tipologia</label>
                                    <select id="tipo" name="tipo">
                                        <option value="monolocale">MONOLOCALE</option>
                                        <option value="bilocale">BILOCALE</option>
                                        <option value="villetta">VILLETTA</option>
                                        <option value="appartamento">APPARTAMENTO</option>
                                        <option value="loft">LOFT</option>
                                    </select>
                                </div>
                                <div class="button-wrapper">
                                    <button type="submit">Crea Casa</button>
                                </div>
                            </form>
                        <% } %>
            </div>

            <%@ include file="/css/footer.jsp" %>

    </body>

</html>