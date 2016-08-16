package br.com.jpamaven;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

public class TesteJPARelacionamento {

    public static void main(String[] args) {

    	 double inicio = System.currentTimeMillis();
    	
        Conta conta = new Conta();
        conta.setTitular("Maria dos Santos");
        conta.setBanco("Caixa");
        conta.setAgencia("043");
        conta.setNumero("54321");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("123.9"));
        movimentacao.setConta(conta);        
        
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimentacao);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
    }
}