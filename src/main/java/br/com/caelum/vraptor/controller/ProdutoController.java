package br.com.caelum.vraptor.controller;

import java.util.List;
//import java.util.Set;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;

@Resource
@Path("/produto")
public class ProdutoController {
	
	private ProdutoDao dao;
	private Result result;
	
	public ProdutoController(ProdutoDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Get()
	public List<Produto> lista() {
		return dao.selectAll();
	}

	@Path("/cadastro")
	public void form() {
	}
	
	@Post()
	public void adiciona(Produto produto) {
		dao.insert(produto);
		result.redirectTo(this).form();
	}

	@Path("remover/{produto.id}")
	public void remover(Produto produto) {
		dao.delete(produto.getId());
		result.redirectTo(this).lista();
	}
	
	@Path("alterar/{produto.id}")
	public Produto alterar(Produto produto) {
		return dao.selectById(produto.getId());
	}
	
	@Path("edita/{produto.id}")
	public void editar(Produto produto) {
		dao.update(produto);
		result.redirectTo(this).lista();
	}

}
