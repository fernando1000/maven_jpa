package br.com.jpamaven;

import javax.persistence.EntityManager;

public class TesteJPA {

    public static void main(String[] args) {

    	 double inicio = System.currentTimeMillis();
    	
        Conta conta = new Conta();
        conta.setTitular("Maria dos Santos");
        conta.setBanco("Caixa");
        conta.setAgencia("043");
        conta.setNumero("54321");

        
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");

        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();
        entityManager.close();
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
    }
}