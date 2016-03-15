package br.com.caelum.vraptor.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProdutoDao {
	
	static Set<Produto> produtos = new HashSet<Produto>();
	Iterator<Produto> it = produtos.iterator();
	
	public Set<Produto> listaTodos() {
		return produtos;
	}
	
	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public void remove(Produto produto) {	
		while (it.hasNext()) {
			Produto p = (Produto) it.next();
			
			if(p.getId() == produto.getId()) {
				it.remove();
			}
		}			
	}

	public Produto getProduto(Produto produto) {
		Produto produto1 = new Produto();
			while (it.hasNext()) {
				Produto p = (Produto) it.next();
				
				if(p.getId() == produto.getId()) {
					produto1 = p;
				}
			}
		return produto1;
	}

}
