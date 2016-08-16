package br.com.jpamaven;

import javax.persistence.EntityManager;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();

        Conta conta = manager.find(Conta.class, 1);

        manager.getTransaction().commit();

        conta.setTitular("Caelum ensino e inovação");

        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
        
        manager.close();
    }
}
