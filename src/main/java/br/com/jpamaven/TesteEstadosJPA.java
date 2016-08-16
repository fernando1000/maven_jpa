package br.com.jpamaven;

import javax.persistence.EntityManager;

public class TesteEstadosJPA {

	public static void main (String [] args){
		
		EntityManager entityManager = new JPAUtil().getEntityManager();        

					  entityManager.getTransaction().begin();
		
	    Conta conta = entityManager.find(Conta.class, 1);

        System.out.println(conta.getTitular());
        
        conta.setTitular("Luiz Ferreira");

        System.out.println(conta.getTitular());
        
        			  entityManager.getTransaction().commit();

        			  entityManager.close();
        
	}
}
