package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class ProdutoService {
	
	@PersistenceContext
	private EntityManager em;
	
	public Produto salvar(Produto p) {
		p = em.merge(p);
		return p;
	}
	
	public Produto buscarPeloId(Long id) {
		Produto produtoEncontrado = em.find(Produto.class, id);
		return produtoEncontrado;
	}
	
	public List<Produto> listar() {
		String jpql = "SELECT p FROM Produto p";
		List<Produto> produtos = em.createQuery(jpql, Produto.class).getResultList();
		return produtos;
	}
	
	public void remover(Produto p) {
		p = em.merge(p);
		em.remove(p);
	}
	
	public Produto atualizar(Produto p) {
		if (p.getId() == null) {
			throw new RuntimeException("Produto não existe");
		}
		
		p = em.merge(p);
		return p;
	}
}