package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		CalculaPrecoIngressoBuilder builder = new CalculaPrecoIngressoBuilder(sessao, quantidade);
		return builder.calculaPrecoIngresso();
	}
}