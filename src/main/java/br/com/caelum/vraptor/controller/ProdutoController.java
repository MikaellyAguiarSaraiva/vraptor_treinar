package br.com.caelum.vraptor.controller;

import java.util.List;
//import java.util.Set;









import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.service.ProdutoDao;
import br.com.caelum.vraptor.validator.Validations;

@Resource
@Path("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDao dao;
	private Result result;
	private Validator validator;
	
	public ProdutoController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}
	
	@Get()
	public List<Produto> lista() {
		return dao.getAll();
	}

	@Path("/cadastro")
	public void form() {
	}
	
	@Post()
	@Path("/adiciona")
	public void adiciona(final Produto produto) {				
		validator.checking(new Validations() { { 
			that(produto.getNome() != null , "ERROR", "nome.nao.informado");
			that(produto.getDescricao() != null , "ERROR", "descricao.nao.informada");
			that(produto.getPreco() != null , "ERROR", "preco.nao.informado");
		} });
		
		validator.onErrorUsePageOf(this).form();
		
		dao.insert(produto);
		result.redirectTo(this).form();
	}

	@Path("remover/{produto.id}")
	public void remover(Produto produto) {
		dao.deleteById(produto.getId());
		result.redirectTo(this).lista();
	}
	
	@Path("alterar/{produto.id}")
	public Produto alterar(final Produto produto) {
		return dao.getById(produto.getId());
	}
	
	@Path("edita/{produto.id}")
	public void editar(final Produto produto) {
		validator.checking(new Validations() { { 
			that(produto.getNome() != null , "ERROR", "nome.nao.informado");
			that(produto.getDescricao() != null , "ERROR", "descricao.nao.informada");
			that(produto.getPreco() != null , "ERROR", "preco.nao.informado");
		} });
		
		validator.onErrorUsePageOf(this).alterar(produto);
		
		dao.update(produto);
		result.redirectTo(this).lista();
	}

}
