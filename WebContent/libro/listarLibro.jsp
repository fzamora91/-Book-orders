<%@include file="/header.jsp" %>
<section>
  <h1>Libros</h1>
  
  <a href="${pageContext.request.contextPath}/LibroAdd">Agregar</a>
  
  <table class="table table-striped table-hover">
  <tbody>
  <tr>
    <th>id</th>
    <th>titulo</th>
    <th>Acciones<th>
   </tr>
  
   <%--${requestScope.autorList.nombre}--%>
   <c:forEach items="${requestScope.libroList}" var="libro">
     <tr>
      <td><c:out value="${libro.id}"></c:out></td>
      <td><c:out value="${libro.titulo}"></c:out></td>
      <td>
          <a href="${pageContext.request.contextPath}/LibroUpdate?id=${titulo.id}">Editar</a>
          <a href="${pageContext.request.contextPath}/LibroDelete?id=${titulo.id}">Eliminar</a>
      </td>
    </tr>
   </c:forEach>
   
 </tbody>
 </table>
  
</section>
<%@include file="/footer.jsp" %> 