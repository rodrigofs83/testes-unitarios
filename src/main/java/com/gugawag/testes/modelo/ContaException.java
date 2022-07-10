package com.gugawag.testes.modelo;

public class ContaException extends Exception {
	private int codigoErr;
	public ContaException(String mensage, int codigoErr){
		super(mensage);
		this.codigoErr =codigoErr;
	}
	public int getCodigoErr() {
		return codigoErr;
	}
	public void setCodigoErr(int codigoErr) {
		this.codigoErr = codigoErr;
	}
}
