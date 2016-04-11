package br.com.caelum.vraptor.controller;

import java.util.List;
//import java.util.Set;







import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.service.ProdutoDao;

@Resource
@Path("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDao dao;
	private Result result;
	
	public ProdutoController(Result result) {
		this.result = result;
	}
	
	@Get()
	public List<Produto> lista() {
		return dao.getAll();
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
		dao.deleteById(produto.getId());
		result.redirectTo(this).lista();
	}
	
	@Path("alterar/{produto.id}")
	public Produto alterar(Produto produto) {
		return dao.getById(produto.getId());
	}
	
	@Path("edita/{produto.id}")
	public void editar(Produto produto) {
		dao.update(produto);
		result.redirectTo(this).lista();
	}

}
