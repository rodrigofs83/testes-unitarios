package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import com.gugawag.testes.modelo.Conta;
import com.gugawag.testes.modelo.ContaException;

public class ContaTest {
	 Conta c1;
	 Conta c2;
	 int numerocontaOrigem ;
	 int numerocontaDestino ;
	    @Before
	    public void configuraConta() {
	        c1 = new Conta();
	        c1.setNumero(10);
	        c1.setTitula("Rodrigo");
	        c2 = new Conta();
	        c2.setNumero(12);
	        c2.setTitula("Rafa");
	        numerocontaOrigem = c1.getNumero();
	        numerocontaDestino = c2.getNumero();
	        }
	    
	 @Test
	 public void TansfereciaComSucesso() throws ContaException{
		 double valor = 10;
		 Conta contaOrigem = c1;
		 contaOrigem.creditar(valor);
		 Conta contaDestino = c2;
		 contaOrigem.transferir(valor,contaDestino );
		 Assertions.assertEquals(valor,contaDestino.getSaldo());
		 
		 
	 }
	 @Test
	 public void soPodeTranferiParaContaDiferentesNumero(){
		assertFalse(numerocontaOrigem==numerocontaDestino);//
		 //assertFalse(numerocontaOrigem==numerocontaOrigem);
	}
	 //testando Exceções
	  @Test(expected=ContaException.class)
	  public void TesteEsperadoUmExcecao() throws ContaException{
		  Conta contaOrigem = c1;
		  Conta contaDestino = c1;
		  double valor = 1;
		  contaOrigem.transferir(valor,contaDestino );
	  }
	  @Test
	  public void VerificaMesagemDeErroEstaCerta(){
		  Conta contaOrigem = c1;
		  Conta contaDestino = c1;
		  double valor = 1;
		  try {
			contaOrigem.transferir(valor,contaDestino);
			fail();
		} catch (ContaException e) {
			// TODO Auto-generated catch block
			 Assertions.assertEquals("não pode tranferir pra mesma conta",e.getMessage());
		}
	  }
	  @Test
	  public void NaopodeTranferiValorIgualAZero() throws ContaException{
		  double valorcredito = 1;
		  double valor = 1;
		  Conta contaOrigem = c1;
		  Conta contaDestino = c2;
		  contaOrigem.creditar(valorcredito);
		  contaOrigem.transferir(valor,contaDestino);
		  Assertions.assertEquals(valor,contaDestino.getSaldo());
		  
	  }
	  @Test
	  public void NaoPodeTranferiValorMaiorQueSaldo() throws ContaException{
		  double valorcredito = 10;
		  double valor = 1;
		  Conta contaOrigem = c1;
		  Conta contaDestino = c2;
		  contaOrigem.creditar(valorcredito);
		  contaOrigem.transferir(valor,contaDestino);
		  Assertions.assertEquals(valor,contaDestino.getSaldo());
	  }
	  
	  @Test
	  public void NaoPodeTransferiParaContaNula() throws ContaException{
		  double valorcredito = 10;
		  double valor = 1;
		  Conta contaOrigem = c1;
		  Conta contaDestino = c2;
		  contaOrigem.creditar(valorcredito);
		  contaOrigem.transferir(valor,contaDestino);
	  }

//    @Test
//    public void deveAlterarNumeroContaNumeroValido() {
        // Config
//    	String numero ="10";
        // teste
//       Assertions.assertEquals(numero,c1.getNumero());
//    }
/*
    @Test
    public void deveComecarContaComSaldoZero() {
        // config
        Conta contaNova = new Conta();

        // teste
        Assertions.assertEquals(0.0, contaNova.getSaldo());
    }

//    @Test
//    public void naoDeveriaMudarSaldoSeValorNegativo(){
//        // config
//        Conta contaSaldoPositivo = new Conta();
//        Double saldoPositivo = 100.0;
//        contaSaldoPositivo.setSaldo(saldoPositivo);
//
//        // executar
//
//        Double valorNegativo = -10.0;
//        contaSaldoPositivo.setSaldo(valorNegativo);
//
//        // teste
//        Assertions.assertEquals(saldoPositivo, contaSaldoPositivo.getSaldo());
//    }
//
//    @Test
//    public void naoDeveriaTerSaldoNegativo(){
//        // config
//        Conta contaSaldoPositivo = new Conta();
//        Double saldoPositivo = 100.0;
//        contaSaldoPositivo.setSaldo(saldoPositivo);
//
//        // executar
//
//        Double valorNegativo = -10.0;
//        contaSaldoPositivo.setSaldo(valorNegativo);
//
//        // teste
//        Assertions.assertTrue(contaSaldoPositivo.getSaldo()>=0);
//    }

    @Test
    public void naoDeveDebitarValorMaiorSaldo() {
        // config
        c1.creditar(100.0);

        // executar

        Assertions.assertThrows(SaldoNegativoInvalidoException.class,
                () -> c1.debitar(200.0));
    }

    @Test
    public void deveDebitarValorIgualSaldo() {
        // config
        c1.creditar(100.0);

        // executar
        try {
            c1.debitar(100.0);
        } catch (SaldoNegativoInvalidoException e) {
            Assertions.fail();
        }

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    @Test
    public void naoDeveCreditarValorNegativo() {

        // executar
        c1.creditar(-100.0);

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }
	        // executa
	        c1.setNumero(numeroContaValido);


	    @Test
	    public void deveAlterarNumeroContaNumeroValido() {
	        // Config
	        String nu
	        // teste
	        Assertions.assertEquals(numeroContaValido, c1.getNumero());
	    }


	    @Test
	    public void deveComecarContaComSaldoZero() {
	        // config
	        Conta contaNova = new Conta();

	        // teste
	        Assertions.assertEquals(0.0, contaNova.getSaldo());
	    }

//	    @Test
//	    public void naoDeveriaMudarSaldoSeValorNegativo(){
//	        // config
//	        Conta contaSaldoPositivo = new Conta();
//	        Double saldoPositivo = 100.0;
//	        contaSaldoPositivo.setSaldo(saldoPositivo);
	//
//	        // executar
	//
//	        Double valorNegativo = -10.0;
//	        contaSaldoPositivo.setSaldo(valorNegativo);
	//
//	        // teste
//	        Assertions.assertEquals(saldoPositivo, contaSaldoPositivo.getSaldo());
//	    }
	//
//	    @Test
//	    public void naoDeveriaTerSaldoNegativo(){
//	        // config
//	        Conta contaSaldoPositivo = new Conta();
//	        Double saldoPositivo = 100.0;
//	        contaSaldoPositivo.setSaldo(saldoPositivo);
	//
//	        // executar
	//
//	        Double valorNegativo = -10.0;
//	        contaSaldoPositivo.setSaldo(valorNegativo);
	//
//	        // teste
//	        Assertions.assertTrue(contaSaldoPositivo.getSaldo()>=0);
//	    }

	    @Test
	    public void naoDeveDebitarValorMaiorSaldo() {
	        // config
	        c1.creditar(100.0);

	        // executar

	        Assertions.assertThrows(SaldoNegativoInvalidoException.class,
	                () -> c1.debitar(200.0));
	    }

	    @Test
	    public void deveDebitarValorIgualSaldo() {
	        // config
	        c1.creditar(100.0);

	        // executar
	        try {
	            c1.debitar(100.0);
	        } catch (SaldoNegativoInvalidoException e) {
	            Assertions.fail();
	        }

	        // teste
	        Assertions.assertEquals(0.0, c1.getSaldo());
	    }

	    @Test
	    public void naoDeveCreditarValorNegativo() {

	        // executar
	        c1.creditar(-100.0);

	        // teste
	        Assertions.assertEquals(0.0, c1.getSaldo());
	    }
	    */
}
