package com.gugawag.testes.modelo;

public class Conta {
    public Conta() {
        this.saldo = 0.0;
    }

    private int numero;
    private String titula;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void  creditar(double valor) throws ContaException {
        if (valor > 0) {
            this.saldo += valor;
            
        }else{
        	throw new ContaException("valor tem que se maior que zero",1);
        }
		
    }

    public void debitar(double valor) throws ContaException {

        if (valor > this.saldo) {
            throw new ContaException("Saldo saldo insuficiente",2);
        }

        if (valor > 0) {
            this.saldo -= valor;
        }
    }

   public void  transferir(double valor,Conta contaDestino) throws ContaException {
	   if(this.getNumero()==contaDestino.getNumero()){
		   throw new ContaException("não pode tranferir pra mesma conta",3);
	   }
       this.debitar(valor);
       contaDestino.creditar(valor);

   }
	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

}
