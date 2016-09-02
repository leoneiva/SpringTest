

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
$.post("removePerfil", {'id' : id}, function() {
// a linha abaixo esconde a tr que veio o click
$("#perfil_"+id).closest("tr").hide();

});
}
</script>



	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Perfil</th>


		</tr>
		<c:forEach items="${perfil}" var="perfil">
			<tr>

				<td>${perfil.id}</td>
				<td>${perfil.perfil}</td>

				
				<td><a href="alteraPerfil?id=${perfil.id}">Alterar</a></td> 
				<td><a href="removePerfil?id=${perfil.id}">Remover</a></td> 
				<td id="perfil_${perfil.id}"><a href="#" onClick="removeAgora(${perfil.id})">Remover com ajax</a></td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>