package br.com.viavarejo.aplication.models;

public class ContextParcela {
	
	private Produto produto; 
	private CondicaoPagamento condicaoPagamento;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	
}
