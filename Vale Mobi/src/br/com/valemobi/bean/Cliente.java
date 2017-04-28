package br.com.valemobi.bean;

public class Cliente {
	
	private long idCustomer;
	private String cpfCnpj;
	private String nmCustomer;
	private boolean active;
	private long vlTotal;
	
	
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNmCustomer() {
		return nmCustomer;
	}
	public void setNmCustomer(String nmCustomer) {
		this.nmCustomer = nmCustomer;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(long vlTotal) {
		this.vlTotal = vlTotal;
	}
	

}
