package model;

public class PessoaJuridicaReferencia {
	
	private int codigo;
	private String razaoSocial;
	private String saldo;
	private String cnpj;
	
	public PessoaJuridicaReferencia() {

	}

	public PessoaJuridicaReferencia(String razaoSocial, String saldo, String cnpj) {
    		this.razaoSocial = razaoSocial;
    		this.saldo = saldo;
    		this.cnpj = cnpj;
    	}
	
	public PessoaJuridicaReferencia(int codigo, String razaoSocial, String saldo, String cnpj) {
		this.codigo = codigo;
		this.razaoSocial = razaoSocial;
		this.saldo = saldo;
		this.cnpj = cnpj;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
