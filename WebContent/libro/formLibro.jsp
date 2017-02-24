<%@include file="/header.jsp" %>
<section>
   <h1>${requestScope.titulo}</h1> 
   <form name="frmLibro" action=""   method="post">
     <label>id</label>
     <input  class="form-control" type="text" name="id" value="${requestScope.libro.id}" required="required"/>
     <br/>
     <label>titulo</label>
     <input  class="form-control" type="text" name="titulo" value="${requestScope.libro.titulo}" required="required"/>
     <br/>
     <input class="btn btn-default" type="submit" name="btnEnviar" value="enviar"/>
   </form>
</section>
<%@include file="/footer.jsp" %> 