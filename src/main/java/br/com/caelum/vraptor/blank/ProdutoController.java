package br.com.caelum.vraptor.blank;

import java.util.Set;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.model.ProdutoDao;

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
	public Set<Produto> lista() {
		return dao.listaTodos();
	}
	
	@Path("/cadastro")
	public void form() {
	}
	
	@Post()
	public void adiciona(Produto produto) {
		dao.adiciona(produto);
		result.redirectTo(this).form();
	}

	@Path("remover/{produto.id}")
	public void remover(Produto produto) {
		dao.remove(produto);
		result.redirectTo(this).lista();
	}
	
	@Path("alterar/{produto.id}")
	public void alterar() {		
	}

}
