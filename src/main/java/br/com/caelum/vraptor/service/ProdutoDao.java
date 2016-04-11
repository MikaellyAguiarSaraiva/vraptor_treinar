package br.com.caelum.vraptor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.persistence.ProdutoMapper;


@Component
@Transactional
public class ProdutoDao {
	
	@Autowired
	private ProdutoMapper mapper;
	
	public Produto getById(int id) {
		return mapper.getById(id);
	}
	
	public List<Produto> getAll() {
		return mapper.getAll();
	}
	
	public void deleteById(int id) {
		mapper.deleteById(id);
	}
	
	public void insert(Produto produto) {
		mapper.insert(produto);
	}
	
	public void update(Produto produto) {
		mapper.update(produto);
	}
}
