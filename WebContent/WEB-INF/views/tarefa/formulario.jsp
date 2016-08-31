<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head> <%@include  file="/WEB-INF/views/headTag.jsp" %></head></head>
<body>
  <%@include  file="/WEB-INF/views/menu.jsp" %>
 <%@include  file="/WEB-INF/views/cabecalho.jsp" %>
 <br>
<h3>Adicionar tarefas</h3>
<form:errors path="tarefa.descricao"/>
<form action="adicionaTarefa" method="post">
Descrição: <br />
<textarea name="descricao" rows="5" cols="100"></textarea><br />
<input type="submit" value="Adicionar">
</form>
</body>
</html>