<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/produto/adiciona'/>" method="post">
	 	Nome : <input type="text" name="produto.nome" /><br/>
	 	Descrição : <input type="text" name="produto.descricao" /><br/>
	 	Preço: <input type="text" name="produto.preco" /><br/>
	 	<input type="submit" value="Salvar" />
	 	<a href="<c:url value='/produto/lista'/>"><input type="button" value="Listar"></a>
	</form>
</body>
</html>