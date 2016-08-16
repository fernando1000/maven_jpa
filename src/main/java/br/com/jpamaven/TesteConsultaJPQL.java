package br.com.jpamaven;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TesteConsultaJPQL {

	public static void main(String [] args){
		
		EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(1);

        //Query query = manager.createQuery("select m from Movimentacao m where m.conta=?1");   
        //query.setParameter(1, conta);
        
        
        Query query = manager.createQuery("select m from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo order by m.valor asc");
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
       
        
        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
        	
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

        manager.close();
	}
}
