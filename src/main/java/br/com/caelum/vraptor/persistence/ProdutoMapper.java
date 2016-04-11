package br.com.caelum.vraptor.persistence;

import java.util.List;

import br.com.caelum.vraptor.model.Produto;

public interface ProdutoMapper{
	
	public Produto getById(int id);
	
	public List<Produto> getAll();
	
	public void deleteById(int id);
	
	public void insert(Produto produto);
		
	public void update(Produto produto);
}
