

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
$.post("removeTarefa", {'id' : id}, function() {
// a linha abaixo esconde a tr que veio o click
$("#tarefa_"+id).closest("tr").hide();

});
}
</script>


	<a href="novaTarefa">Criar nova tarefa</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
		</tr>

<!-- 		// forEach com paginação -->


		

				<c:forEach items="${usuarios}" var="contagem" varStatus="status">

<%-- <c:out value="count: ${status.count}"/> --%>
		<c:set var="contar" value="${loopCounter.count}" />

						</c:forEach>
						<c:out value="Tamanho do array é:  ${contar / 3}"/>	

		<c:set var="inicio" value="0" />
		<c:set var="fim" value="10" />	
		${tamanho}
		
		<c:forEach begin="${inicio}" end="${fim}" items="${usuarios}" var="usuario">
			<tr>
		
				<td>${usuario.id}</td>
				<td>${usuario.login}</td>
				<td>${usuario.senha}</td>
				
				<td><a href="mostraTarefa?id=${usuario.id}">Alterar</a></td>
				<td><a href="removeTarefa?id=${usuario.id}">Remover</a></td>
				<td id="tarefa_${usuario.id}"><a href="#" onClick="removeAgora(${usuario.id})">Remover com ajax</a></td>
			</tr>
			
		</c:forEach>
	</table>
	<br>

<<  <  >  >>

</body>
</html>