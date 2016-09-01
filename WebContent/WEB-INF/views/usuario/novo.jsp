<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="data"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include  file="/WEB-INF/views/headTag.jsp" %>
<title>Cadastro de Usuário</title>
</head>
<body>
  <%@include  file="/WEB-INF/views/menu.jsp" %>
 <%@include  file="/WEB-INF/views/cabecalho.jsp" %>

	<h1>Novo cadastro</h1>
	<hr />
	<form action="salvaUsuario" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" /><br /></td>
			</tr>
						<tr>
				<td>Senha</td>
				<td><input type="text" name="senha" /><br /></td>
			</tr>
		</table>
		<input type="submit" value="Gravar" />
	</form>
	<hr />
</body>
</html>
			
			
<!-- 			<tr> -->
<!-- 				<td>Senha</td> -->
<%-- 				<td><data:campoData id="senha" /><br /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>CPF</td> -->
<!-- 				<td><input type="text" name="cpf" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>RG</td> -->
<!-- 				<td><input type="text" name="rg" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Sexo</td> -->
<!-- 				<td><input type="radio" name="sexo" value="Feminino" />Feminino -->
<!-- 					<input type="radio" name="sexo" value="Masculino" />Masculino</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>E-mail</td> -->
<!-- 				<td><input type="text" name="email" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Estado civil</td> -->
<!-- 				<td><select> -->
<!-- 						<option value="casado(a)">Casado(a)</option> -->
<!-- 						<option value="divorciado">Divorciado(a)</option> -->
<!-- 						<option value="solteiro" selected="selected">Solteiro(a)</option> -->
<!-- 						<option value="viuvo">Viuvo</option> -->
<!-- 				</select></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><a -->
<!-- 					href="http://www.buscacep.correios.com.br/servicos/dnec/menuAction.do?Metodo=menuEndereco" -->
<!-- 					target="_blanck">CEP</a></td> -->
<!-- 				<td><input type="text" name="cep" /> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Endereço</td> -->
<!-- 				<td><input type="text" name="endereco" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Numero</td> -->
<!-- 				<td><input type="text" name="numero" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Bairro</td> -->
<!-- 				<td><input type="text" name="bairro" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Municipio</td> -->
<!-- 				<td><input type="text" name="municipio" /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>UF</td> -->
<!-- 				<td><input type="text" name="uf" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Telefone recidencial</td> -->
<!-- 				<td><input type="text" name="telefone" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Telefone celular</td> -->
<!-- 				<td><input type="text" name="celular" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Portador de deficiência</td> -->
<!-- 				<td> -->
<!-- 					<input type="radio" name="deficiente" value="sim" />Sim -->
<!-- 					<input type="radio" name="deficiente" value="nao" />Não -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Numero de pessoas responsáveis</td> -->
<!-- 				<td><input type="text" name="responsavelPor" /><br /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Receber ofertas do hotel</td> -->
<!-- 				<td><input type="checkbox" name="ofertas" value="ofertas" /> -->
<!-- </tr> -->