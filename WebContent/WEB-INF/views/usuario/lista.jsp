

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
		<c:forEach items="${usuarios}" var="usuario">
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
</body>
</html>