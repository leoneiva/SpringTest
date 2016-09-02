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
 
 	<h1>Alterar usuário - ${usuario.id}</h1>
	<hr />

	<form action="salvaAlteracaoUsuario" method="post" id="alterauser">
	<input type="hidden" name="id" value="${usuario.id}" />
	
	<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" value="${usuario.login}"><br /></td>
			</tr>
						<tr>
				<td>Senha</td>
				<td><input type="text" name="senha" value="${usuario.senha}"><br /></td>
			</tr>
			<tr>
					<td>Ativo</td>
				<td>
	 <select name="ativo">
			
			
					<option value="1" <c:if test="${usuario.ativo == 1}"> selected</c:if>>
					Ativo</option>
				<option value="0" <c:if test="${usuario.ativo == 0}"> selected</c:if>>
					Inativo</option>

		</select> 
					</tr>
			<tr>


					<td>Perfil</td>
				<td>
	 <select name="perfil">
			<c:forEach items="${perfil}" var="perfil">
				<option value="${perfil.id}"
					<c:if test="${perfil.id eq usuario.perfil}">selected</c:if>>
					${perfil.perfil}</option>
			</c:forEach>
		</select> 
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