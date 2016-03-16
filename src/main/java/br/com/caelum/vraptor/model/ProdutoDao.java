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

	public Produto alterar(Produto produto) {
		Produto produtoAlt = new Produto();
			while (it.hasNext()) {
				Produto p = (Produto) it.next();
				
				if(p.getId() == produto.getId()) {
					produtoAlt = p;
				}
			}
		return produtoAlt;
	}
	
	public void edita(Produto produto) {
		while (it.hasNext()) {
			Produto p = (Produto) it.next();
			
			if(p.getId() == produto.getId()) {
				it.remove();
			}
		}
		
		produtos.add(produto);
	}

}
