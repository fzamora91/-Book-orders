<%@include file="/header.jsp" %>
<section>
 <h1>Autores</h1>  
 <a href="${pageContext.request.contextPath}/AutorAdd">Agregar</a>
   
 <table class="table table-striped table-hover">
  <tbody>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Role</th>
    <th>Acciones<th>
   </tr>
  
   <%--${requestScope.autorList.nombre}--%>
   <c:forEach items="${requestScope.autorList}" var="autor">
     <tr>
      <td><c:out value="${autor.id}"></c:out></td>
      <td><c:out value="${autor.nombre}"></c:out></td>
      <td><c:out value="${autor.apellido}"></c:out></td>
      <td>
          <a href="${pageContext.request.contextPath}/AutorUpdate?id=${autor.id}">Editar</a>
          <a href="${pageContext.request.contextPath}/AutorDelete?id=${autor.id}">Eliminar</a>
      </td>
    </tr>
   </c:forEach>
   
 </tbody>
 </table>
    
</section>
<%@include file="/footer.jsp" %> 