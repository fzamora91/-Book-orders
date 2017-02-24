<%@include file="/header.jsp" %>
<section>
  <h1>Clientes</h1> 
  <a href="${pageContext.request.contextPath}/ClienteAdd">Agregar</a>
  
  <table class="table table-striped table-hover">
  <tbody>
  <tr>
    <th>id</th>
    <th>nombre</th>
    <th>Acciones<th>
   </tr>
  
   <%--${requestScope.autorList.nombre}--%>
   <c:forEach items="${requestScope.clienteList}" var="cliente">
     <tr>
      <td><c:out value="${cliente.id}"></c:out></td>
      <td><c:out value="${cliente.nombre}"></c:out></td>
      <td>
          <a href="${pageContext.request.contextPath}/ClienteUpdate?id=${cliente.id}">Editar</a>
          <a href="${pageContext.request.contextPath}/ClienteDelete?id=${cliente.id}">Eliminar</a>
      </td>
    </tr>
   </c:forEach>
   
 </tbody>
 </table>
  
</section>
<%@include file="/footer.jsp" %> 