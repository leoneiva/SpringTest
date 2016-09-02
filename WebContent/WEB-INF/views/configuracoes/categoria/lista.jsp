

<%-- 
1 - Finaliza tarefa é ajax.
2 - Remover tem 2 tipos. Ajax e retorno.



 --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
 <%@include  file="/WEB-INF/views/headTag.jsp" %>
</head>
<body>
  <%@include  file="/WEB-INF/views/menu.jsp" %>
 <%@include  file="/WEB-INF/views/cabecalho.jsp" %>


<%-- Script jqyery para ajax --%>
<%-- AJAX PARA REMOVER TAREFA --%>
	<script type="text/javascript">
function removeAgora(id) {
$.post("removeCategoria", {'id' : id}, function() {
// a linha abaixo esconde a tr que veio o click
$("#categoria_"+id).closest("tr").hide();

});
}
</script>



	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Categoria</th>


		</tr>
		<c:forEach items="${categoria}" var="categoria">
			<tr>

				<td>${categoria.id}</td>
				<td>${categoria.categoria}</td>

				
				<td><a href="alteraCategoria?id=${categoria.id}">Alterar</a></td> 
				<td><a href="removeCategoria?id=${categoria.id}">Remover</a></td> 
				<td id="categoria_${categoria.id}"><a href="#" onClick="removeAgora(${categoria.id})">Remover com ajax</a></td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>