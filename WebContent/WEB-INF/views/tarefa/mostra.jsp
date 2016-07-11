<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
<link href="js/JQuery/jquery-ui.css" rel="stylesheet">
<script src="js/JQuery/jquery-3.0.0.min.js"></script>

<!-- 	<script src="js/JQuery/jquery-1.10.2.js"></script> -->
	<script src="js/JQuery/jquery.ui.core.js"></script>
	<script src="js/JQuery/jquery.ui.widget.js"></script>
	<script src="js/JQuery/jquery.ui.datepicker.js"></script>
	<!-- <script src="js/jquery-ui.js"></script> -->
</head>
<body>

	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" /> Descrição:<br />
		<textarea name="descricao" cols="100" rows="5">
${tarefa.descricao}
</textarea>
		<br /> Finalizado? <input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado? 'checked' : '' } /> <br /> Data de
		finalização: <br /> 
		
		<caelum:campoData id="dataFinalizacao" />
		
		
<!-- 		<input type="text" name="dataFinalizacao" -->
<%-- 			value="<fmt:formatDate --%>
<%-- value="${tarefa.dataFinalizacao.time}" --%>
<%-- pattern="dd/MM/yyyy" />" /> --%>

		<br /> <input type="submit" value="Alterar" />
	</form>
</body>
</html>