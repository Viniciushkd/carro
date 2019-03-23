package br.com.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.model.Carro;

public class CarroHealper {
	
	private EntityManager em;
	
	public CarroHealper(EntityManager em) {
		this.em = em;
	}
	
	public String criarCarro(Carro carro) {
		try {
			em.getTransaction().begin();
			em.persist(carro);
			em.getTransaction().commit();
			return "Carro criado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Carro> listarCarros(){
		TypedQuery<Carro> query = em.createQuery("Select c from Carro c", Carro.class);
		return query.getResultList();
	}
	
	public String deleteCarro(Carro carro) {
		try {
			em.getTransaction().begin();
			em.remove(carro);
			em.getTransaction().commit();
			return "Carro deletado";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}
