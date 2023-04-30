package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class NotaCompra {

	public BigDecimal getCalculoTotalNota() {
		//stream é uma estrutura de dados para manipular uma lista
		BigDecimal total = this.listaNotaCompraItem.stream()
				.map(i -> i.getCalculoTotalItem())
				//Faz a soma (valor inicial, somatoria de 2 em 2 itens)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return total;
	}
	

	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		if (listaNotaCompraItem == null) {
			this.listaNotaCompraItem = new ArrayList<>();
		}
		this.listaNotaCompraItem = listaNotaCompraItem;
	}

}