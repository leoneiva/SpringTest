

<%-- 
1 - Finaliza tarefa é ajax.
2 - Remover tem 2 tipos. Ajax e retorno.



 --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link type="text/css" href="recursos/css/tarefas.css" rel="stylesheet" />
<script src="js/JQuery/jquery-3.0.0.min.js"></script>
</head>
<body>

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
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				
				<%-- Verifica se tarefa está finalizada --%>
				<c:if test="${tarefa.finalizado eq false}">
										<td id="tarefa_${tarefa.id}"><center><a href="#"
						onClick="finalizaAgora(${tarefa.id})">Finalizar</a></center></td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td><center><img src="recursos/imagens/ok.png" width=24></center></td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				
				<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<td id="tarefa_${tarefa.id}"><a href="#" onClick="removeAgora(${tarefa.id})">Remover com ajax</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>