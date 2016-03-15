<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>NOME</th>
					<th>DESCRICAO</th>
					<th>A��ES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach  items="${produtoList}" var="produto">					
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.descricao}</td>
						<td> <a href="<c:url value='/produto/remover/${produto.id}'/>">EXCLUIR</a> - <a href="<c:url value='/produto/alterar/${produto.id}'/>">ALTERAR</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
