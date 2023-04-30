package br.inatel.labs.labjpa.dao;

import br.inatel.labs.labjpa.entity.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FornecedorDAO {

  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
  private EntityManager em = emf.createEntityManager();

  public void salvar(Fornecedor fornecedor) {
    em.getTransaction().begin();
    em.merge(fornecedor);
    em.getTransaction().commit();
  }

  public void remover(Long id) {
    em.getTransaction().begin();
    Fornecedor fornecedor = em.find(Fornecedor.class, id);
    em.remove(fornecedor);
    em.getTransaction().commit();
  }

  public List<Fornecedor> buscarTodos() {
    TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
    return query.getResultList();
  }

  public Fornecedor buscarPorId(Long id) {
    return em.find(Fornecedor.class, id);
  }

  public void fechar() {
    em.close();
    emf.close();
  }
}
