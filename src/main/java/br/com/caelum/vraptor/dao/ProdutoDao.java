package br.com.caelum.vraptor.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.model.Produto;

@Component
public class ProdutoDao {
	
	/*static Set<Produto> produtos = new HashSet<Produto>();
	Iterator<Produto> it = produtos.iterator();*/
	
	private SqlSessionFactory sqlSessionFactory;
	
	public ProdutoDao() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	/**
	* Returns the list of all Contact instances from the database.
	* @return the list of all Contact instances from the database.
	*/
	@SuppressWarnings("unchecked")
	public List<Produto> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Produto> list = session.selectList("Produto.getAll");
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	* Returns a Contact instance from the database.
	* @param id primary key value used for lookup.
	* @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
	*/
	public Produto selectById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Produto produto = (Produto) session.selectOne("Produto.getById", id);
			return produto;
		} finally {
			session.close();
		}
	}
	
	/**
	* Updates an instance of Contact in the database.
	* @param contact the instance to be updated.
	*/
	public void update(Produto produto) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Produto.update", produto);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
	
	
	
	/*public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public void remove(Produto produto) {	
		removeIndexOf(produto);
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
		removeIndexOf(produto);	
		produtos.add(produto);
	}
	
	public void removeIndexOf(Produto produto) {
		while (it.hasNext()) {
			Produto p = (Produto) it.next();
			
			if(p.getId() == produto.getId()) {
				it.remove();
			}
		}
	}*/

}
