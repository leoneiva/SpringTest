<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
 <%@include  file="/WEB-INF/views/headTag.jsp" %>

</head>
<body>
  <%@include  file="/WEB-INF/views/menu.jsp" %>
 <%@include  file="/WEB-INF/views/cabecalho.jsp" %>
 
 	<h1>Alterar Categoria - ${categoria.id}</h1>
	<hr />

	<form action="salvaAlteracaoCategoria" method="post" id="alterauser">
	<input type="hidden" name="id" value="${categoria.id}" />
	
	<table>
						<tr>
				<td>Categoria</td>
				<td><input type="text" name="categoria" value="${categoria.categoria}"><br /></td>
			</tr>
			<tr>
				
		</table>	



		<%-- 		<caelum:campoData id="dataFinalizacao" /> --%>


		<!-- 		<input type="text" name="dataFinalizacao" -->
		<%-- 			value="<fmt:formatDate --%>
		<%-- value="${tarefa.dataFinalizacao.time}" --%>
		<%-- pattern="dd/MM/yyyy" />" /> --%>

		<br /> <input type="submit" value="Alterar" />
	</form>
		<hr />
</body>
</html>