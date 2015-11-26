package br.com.caelum.agiletickets.domain.precos;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculaPrecoIngressoBuilder {
	private Sessao sessao;
	private int quantidade;
	private CalculaPrecoIngresso calculaPrecoIngresso;

	public CalculaPrecoIngressoBuilder(Sessao sessao, int quantidade) {
		super();
		this.sessao = sessao;
		this.quantidade = quantidade;
	}

	public BigDecimal calculaPrecoIngresso() {
		String tipo = this.sessao.getEspetaculo().getTipo().toString().substring( 0, 1 ).toUpperCase() + this.sessao.getEspetaculo().getTipo().toString().substring( 1 ).toLowerCase();
		String className = "br.com.caelum.agiletickets.domain.precos.CalculaPrecoIngresso"
				+ tipo;
		
		try {
			@SuppressWarnings("unchecked")
			Class<CalculaPrecoIngresso> cls = (Class<CalculaPrecoIngresso>) Class.forName(className);
			Constructor<CalculaPrecoIngresso> constructor =
					cls.getConstructor(Sessao.class, int.class);
			calculaPrecoIngresso = constructor.newInstance(this.sessao, this.quantidade);
		} catch (ClassNotFoundException e) {
			calculaPrecoIngresso = new CalculaPrecoIngressoDefault(this.sessao, this.quantidade);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return calculaPrecoIngresso.calcula();
	}

}
