package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoIngressoBallet extends CalculaPrecoIngresso {
	public CalculaPrecoIngressoBallet(Sessao sessao, int quantidade) {
		super(sessao, quantidade);
	}
	
	@Override
	public BigDecimal calcula() {
		this.preco = calculaPreco(0.20, 0.50);
		this.preco = this.preco.multiply(BigDecimal.valueOf(this.quantidade));
		return calcularPrecoDuracao();
	}
}