package br.com.caelum.vraptor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.model.Produto;


@Component
public class ProdutoDao {

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
		
	/**
	* Insert an instance of Contact into the database.
	* @param contact the instance to be persisted.
	*/
	public void insert(Produto produto) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Produto.insert", produto);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**
	* Delete an instance of Contact from the database.
	* @param id primary key value of the instance to be deleted.
	*/
	public void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Produto.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}

}
