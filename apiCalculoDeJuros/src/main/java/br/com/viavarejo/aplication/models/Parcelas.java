package br.com.viavarejo.aplication.models;

import java.util.ArrayList;

public class Parcelas {
	
	private int numeroParcela;
	private double valor;
	private double taxaJurosAoMes;

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public double getValor() {
		return Math.round(valor * 100.0) / 100.0;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTaxaJurosAoMes() {
		return Math.round(taxaJurosAoMes * 100.0) / 100.0;
	}

	public void setTaxaJurosAoMes(double taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

	public ArrayList<Parcelas> calcParcelasComJuros(CondicaoPagamento pagamento, double vlrProduto) {
		
		ArrayList<Parcelas> listParcelas = new ArrayList<Parcelas>();
		int numParcela = 1;
		double valorParcela;
		double taxaSelic = 1.15/100;
			
		// Se a qtde de parcelas for maior que 6, o valor da parcela deve conter a taxa de juros
		if(pagamento.getQtdeParcelas() <= 6) {
			
			valorParcela = (vlrProduto - pagamento.getValorEntrada()) / pagamento.getQtdeParcelas();
			while (numParcela <= pagamento.getQtdeParcelas()) {
					
				Parcelas parcela = new Parcelas();
				parcela.numeroParcela = numParcela;
				parcela.taxaJurosAoMes = 0;
				parcela.valor = valorParcela;
				listParcelas.add(parcela);
				numParcela++;
			}
			return listParcelas;
			
		}else{
					
			valorParcela = (vlrProduto - pagamento.getValorEntrada()) / pagamento.getQtdeParcelas();
			while (numParcela <= pagamento.getQtdeParcelas()) {
				Parcelas parcela = new Parcelas();
				
	               if(numParcela <= 6) {
			
	            	   parcela.taxaJurosAoMes = 0;
	            	   parcela.valor = valorParcela;
	         	   
				   }else {
					   
					   parcela.taxaJurosAoMes = taxaSelic;
					   parcela.valor = valorParcela + (valorParcela * taxaSelic);
				   }
						
				parcela.numeroParcela = numParcela;				
				listParcelas.add(parcela);
				numParcela++;
			}
			return listParcelas;			
		}
	}
}
