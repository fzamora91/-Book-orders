<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta content="UTF-8">
 <title>Home</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css" />

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" >
 </script>

 
</head>
<body>
  <header>
  </header>
  <nav>
    <ul>
      <li><a href="${pageContext.request.contextPath}/Index">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/AutorDefault">Autor</a></li>
      <li><a href="${pageContext.request.contextPath}/LibroDefault">Libro</a></li>
      <li><a href="${pageContext.request.contextPath}/ClienteDefault">Cliente</a></li>
    </ul>
  </nav>