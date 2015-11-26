package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoIngressoCinema extends CalculaPrecoIngresso {
	
	public CalculaPrecoIngressoCinema(Sessao sessao, int quantidade) {
		super(sessao, quantidade);
	}
	
	@Override
	public BigDecimal calcula() {
		this.preco = calculaPreco(0.10, 0.05);
		return this.preco.multiply(BigDecimal.valueOf(quantidade));
	}
}