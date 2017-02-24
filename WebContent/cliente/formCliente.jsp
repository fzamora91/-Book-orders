<%@include file="/header.jsp" %>
<section>
   <h1>${requestScope.titulo}</h1> 
   <form name="frmCliente" action=""   method="post">
      <label>id</label>
      <input  class="form-control" type="text" name="id" value="${requestScope.cliente.id}" required="required"/>
      <br/>
      
      <label>nombre</label>
      <input  class="form-control" type="text" name="nombre" value="${requestScope.cliente.nombre}" required="required"/>
      <br/>
     
      <input class="btn btn-default" type="submit" name="btnEnviar" value="enviar"/>
   </form>
</section>
<%@include file="/footer.jsp" %> 