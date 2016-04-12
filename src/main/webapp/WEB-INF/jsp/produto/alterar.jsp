<%@ include file="../head.jsp"%>
<body>
	<div>
		<div class="col-lg-12">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div id="painel">
					<c:forEach var="error" items="${errors}">
						<div class="alert alert-danger" role="alert">
							${error.category} - ${error.message}
						</div>
					</c:forEach>
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<label>Alterar Produto</label>
						</div>
						<div class="panel-body">
							<form action="<c:url value='/produto/edita/${produto.id}'/>" method="post">
								<div class="form-group">
									<label>Nome : </label> 
									<input type="text" name="produto.nome" value="${produto.nome}" class="form-control" />
								</div>
								<div class="form-group">
									<label>Descrição :</label>
									<input type="text" value="${produto.descricao}" name="produto.descricao" class="form-control" />
								</div>
								<div class="form-group">
									<label>Preço : </label> 
									<input type="text" name="produto.preco" value="${produto.preco}" class="form-control" />
								</div>
								<input type="submit" value="Editar" class="btn btn-default" />
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
</body>
</html>