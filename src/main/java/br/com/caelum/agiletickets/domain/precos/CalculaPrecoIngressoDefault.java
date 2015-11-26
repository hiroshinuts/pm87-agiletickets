package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoIngressoDefault extends CalculaPrecoIngresso {
	public CalculaPrecoIngressoDefault(Sessao sessao, int quantidade) {
		super(sessao, quantidade);
	}
	
	@Override
	public BigDecimal calcula() {
		this.preco = this.sessao.getPreco();
		return this.preco.multiply(BigDecimal.valueOf(this.quantidade));
	}
}