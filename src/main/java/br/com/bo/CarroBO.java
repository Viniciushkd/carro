package br.com.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.helper.CarroHealper;
import br.com.model.Carro;

public class CarroBO {

	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persistenciaJPA");
	static final EntityManager EM = EMF.createEntityManager();
	static CarroHealper cHelper = new CarroHealper(EM);
	
	public void criarCarro(Carro carro) {
		System.out.println(cHelper.criarCarro(carro));
	}
	
	public List<Carro> listarCarros() {
		return cHelper.listarCarros();
	}
	
	public Carro buscarCarro(int id) {
		return listarCarros().stream().filter(c -> c.getIdcarro() == id).findAny().orElse(null);
	}
	
	public Carro deleteCarro(int id) {
		Carro carro = buscarCarro(id);
		System.out.println(cHelper.deleteCarro(carro));
		return carro;
	}
}
