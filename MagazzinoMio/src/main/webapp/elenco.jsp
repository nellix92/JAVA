<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Articolo"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Articolo> articoli = (List<Articolo>) request.getSession().getAttribute("listaArticoli");
	for (Articolo articolo : articoli) {
	%>

	<tr>
		<td>
			<%
			articolo.getCodice();
			%>
		</td>
		<td>
			<%
			articolo.getDescrizione();
			%>
		</td>
		<td>
			<%
			articolo.getQuantita();
			%>
		</td>

	</tr>
	<%
	}
	%>

</body>
</html>