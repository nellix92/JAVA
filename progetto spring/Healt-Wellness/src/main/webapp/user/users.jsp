<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
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
    <%@ include file="../css/navbar.jsp"%>

    <div class="main container mt-3">  <%
          List<UserDTO> list = (List<UserDTO>) request.getSession().getAttribute("list");
       %>

       <br>

       <table class="table table-striped table-bordered">  <thead>
             <tr>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Usertype</th>
                <th scope="col"></th>

             </tr>
          </thead>
          <tbody>  <%
             for (UserDTO u : list) {
          %>
          <tr>
             <td><%=u.getUsername()%></td>
             <td><%=u.getPassword()%></td>
             <td><%=u.getUsertype()%></td>
             <td>  <a href="/user/read?id=<%=u.getId()%>" class="text-dark">
                <i class="fas fa-eye"></i>
             </a></td>


          </tr>
          <%
             }
          %>
          </tbody>
       </table>



    </div>
    <br>
    <%@ include file="../css/footer.jsp"%>
</body>
</html>
