package model;

public class PessoaFisicaReferencia {
	private int codigo;
	private String nome;
	private String saldo;
	private String cpf;

	public PessoaFisicaReferencia() {

	}

	public PessoaFisicaReferencia(String nome, String saldo, String cpf) {
    		this.nome = nome;
    		this.saldo = saldo;
    		this.cpf = cpf;
    	}
	
	public PessoaFisicaReferencia(int codigo, String nome, String saldo, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.saldo = saldo;
		this.cpf = cpf;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}