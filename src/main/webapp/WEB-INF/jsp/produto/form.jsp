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
							<label>Cadastro Produto</label>
						</div>
						<div class="panel-body">
							<form action="<c:url value='/produto/adiciona'/>" method="post">
								<div class="form-group">
									<label>Nome : </label> <input type="text" name="produto.nome" class="form-control" value="${produto.nome}"/>
								</div>
								<div class="form-group">
									<label>Descrição :</label> <input type="text" name="produto.descricao" class="form-control" value="${produto.descricao}"/>
								</div>
								<div class="form-group">
									<label>Preço : </label> <input type="text" name="produto.preco" class="form-control" value="${produto.preco}" />
								</div>
								<input type="submit" value="Salvar" class="btn btn-default" />
								<a href="<c:url value='/produto/lista'/>">
									<input type="button" value="Listar" class="btn btn-default">
								</a>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var produto = new ProdutoModel({
		nome: 'teste3',
		descricao: 'descricao3',
		preco: 3
	});
	produto.save(
			null,
			{
				success: function(model, response) {
					console.log(model);
				},
				error: function(model, response) {
					console.log('ocorreu erro!');
				}
			});
</script>
</html>