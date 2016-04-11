<%@ include file="../head.jsp"%>
<body>
	<div>
		<div class="col-lg-12">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="panel panel-default" id="painel">
					<div class="panel-heading">
						<label>Cadastro Produto</label>
					</div>
					<div class="panel-body">
						<form action="<c:url value='/produto/adiciona'/>" method="post">
							<div class="form-group">
								<label>Nome : </label> <input type="text" name="produto.nome"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Descrição :</label> <input type="text"
									name="produto.descricao" class="form-control" />
							</div>
							<div class="form-group">
								<label>Preço : </label> <input type="text" name="produto.preco"
									class="form-control" />
							</div>
							<input type="submit" value="Salvar" class="btn btn-default" /> <a
								href="<c:url value='/produto/lista'/>"><input type="button"
								value="Listar" class="btn btn-default"></a>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
</body>
</html>