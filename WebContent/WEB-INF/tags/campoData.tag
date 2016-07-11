<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="id" required="true"%>
<!-- N�O FUNCIONA O CALEND�RIO E N�O EST� RESGATANDO A DATA -->
<input id="${id}" name="${id}" value="<fmt:formatDate value='${tarefa.dataFinalizacao.time}' pattern='dd/MM/yyyy' />"/>
<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy'
	});
</script>