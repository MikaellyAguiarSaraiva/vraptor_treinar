<%@ include file="../head.jsp"%>
<body>
	<div>
		<div class="col-lg-12">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="panel panel-default" id="painel">
					<div class="panel-heading">
						<label>Listagem Produtos</label>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>NOME</th>
									<th>DESCRICAO</th>
									<th>AÇÕES</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${produtoList}" var="produto">
									<tr>
										<td>${produto.nome}</td>
										<td>${produto.descricao}</td>
										<td> 
											&nbsp;&nbsp;&nbsp;<a href="<c:url value='/produto/remover/${produto.id}'/>"><i class="glyphicon glyphicon-remove" title="remover"></i></a>
											&nbsp;&nbsp;&nbsp;<a href="<c:url value='/produto/alterar/${produto.id}'/>"><i class="glyphicon glyphicon-pencil" title="alterar"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="<c:url value='/produto/cadastro'/>"><input class="btn btn-default" type="button" value="Adicionar"></a>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

</body>
</html>
