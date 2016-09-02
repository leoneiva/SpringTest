

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
$.post("removePrioridade", {'id' : id}, function() {
// a linha abaixo esconde a tr que veio o click
$("#prioridade_"+id).closest("tr").hide();

});
}
</script>



	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Prioridade</th>


		</tr>
		<c:forEach items="${prioridade}" var="prioridade">
			<tr>

				<td>${prioridade.id}</td>
				<td>${prioridade.prioridade}</td>

				
				<td><a href="alteraPrioridade?id=${prioridade.id}">Alterar</a></td> 
				<td><a href="removePrioridade?id=${prioridade.id}">Remover</a></td> 
				<td id="prioridade_${prioridade.id}"><a href="#" onClick="removeAgora(${prioridade.id})">Remover com ajax</a></td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>