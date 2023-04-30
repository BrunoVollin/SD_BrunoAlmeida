package br.inatel.labs.labjpa.dto;

import java.math.BigDecimal;

import br.inatel.labs.labjpa.entity.Fornecedor;

//This is a Data Transfer Object class that has the purpose of transporting data
public class TotalCompradoPorFornecedorDTO {
	private String fornecedorRazaoSocial;
	
	private BigDecimal totalComprado;
	
	public TotalCompradoPorFornecedorDTO(Fornecedor fornecedor, BigDecimal totalComprado) {
		this.fornecedorRazaoSocial = fornecedor.getRazaoSocial();
		this.totalComprado = totalComprado;
	}

	public String getFornecedorRazaoSocial() {
		return fornecedorRazaoSocial;
	}
	
	public BigDecimal getTotalComprado() {
		return totalComprado;
	}

	@Override
	public String toString() {
		return "TotalCompradoPorFornecedorDTO [totalComprado=" + totalComprado + "]";
	}
	
	
}