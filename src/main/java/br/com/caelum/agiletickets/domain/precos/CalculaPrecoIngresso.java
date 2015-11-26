package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public abstract class CalculaPrecoIngresso {
	
	public BigDecimal preco;
	public Sessao sessao;
	public int quantidade;
	
	public CalculaPrecoIngresso(Sessao sessao, int quantidade) {
		super();
		this.sessao = sessao;
		this.quantidade = quantidade;
	}

	public abstract BigDecimal calcula();

	public BigDecimal calculaPreco(double valor, double condicao) {
		this.preco = this.sessao.getPreco();
		if ((this.sessao.getTotalIngressos() - this.sessao.getIngressosReservados())
				/ this.sessao.getTotalIngressos().doubleValue() <= condicao) {
			this.preco = this.sessao.getPreco().add(
					this.sessao.getPreco().multiply(BigDecimal.valueOf(valor)));
		}
		return this.preco;
	}
	
	public BigDecimal calcularPrecoDuracao() {
		if(sessao.getDuracaoEmMinutos() > 60){
			this.preco = this.preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return this.preco;
	}
}
