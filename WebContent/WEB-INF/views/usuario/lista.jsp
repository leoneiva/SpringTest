

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
<%-- AJAX PARA FINALIZAR TAREFA --%>
	<script type="text/javascript">
function finalizaAgora(id) {
$.post("finalizaTarefa", {'id' : id}, function() {
// selecionando o elemento html através da
// ID e alterando o HTML dele
$("#tarefa_"+id).html("<center>...<img src='recursos/imagens/ok.png' width=24>...</center>");
});
}
</script>
<%-- AJAX PARA REMOVER TAREFA --%>
	<script type="text/javascript">
function removeAgora(id) {
$.post("removeUsuario", {'id' : id}, function() {
// a linha abaixo esconde a tr que veio o click
$("#tarefa_"+id).closest("tr").hide();

});
}
</script>



	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Perfil</th>
			<th>Senha</th>

		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
// TODO FAZER UMA CLASSE PARA VOLTAR ESTA INFORMAÇÃO
				<td>${usuario.id}</td>
				<td>${usuario.login}</td>
				<td>${usuario.perfil} - 
				<c:if test="${usuario.perfil == 1}" >Usuário</c:if>
				<c:if test="${usuario.perfil == 2}" >Administrador</c:if>
				<c:if test="${usuario.perfil == 3}" >Técnico</c:if>
				<c:if test="${usuario.perfil == 0}" >Não definido</c:if>
				
				</td>
				<td>${usuario.senha}</td>
				
				<%-- Verifica se tarefa está finalizada --%>
<%-- 				<c:if test="${tarefa.finalizado eq false}"> --%>
<%-- 										<td id="tarefa_${tarefa.id}"><center><a href="#" --%>
<%-- 						onClick="finalizaAgora(${tarefa.id})">Finalizar</a></center></td> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${tarefa.finalizado eq true}"> --%>
<%-- 					<td><center><img src="recursos/imagens/ok.png" width=24></center></td> --%>
<%-- 				</c:if> --%>
<%-- 				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" --%>
<%-- 						pattern="dd/MM/yyyy" /></td> --%>
				
				<td><a href="alteraUsuario?id=${usuario.id}">Alterar</a></td> 
				<td><a href="removeUsuario?id=${usuario.id}">Remover</a></td> 
				<td id="tarefa_${usuario.id}"><a href="#" onClick="removeAgora(${usuario.id})">Remover com ajax</a></td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>