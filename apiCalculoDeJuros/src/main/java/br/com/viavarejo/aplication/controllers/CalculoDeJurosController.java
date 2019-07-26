package br.com.viavarejo.aplication.controllers;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.viavarejo.aplication.models.ContextParcela;
import br.com.viavarejo.aplication.models.Parcelas;


@RestController
@RequestMapping()
public class CalculoDeJurosController {
	
	@PostMapping("/calculoDeJuros")
	public String parcelarProduto(@RequestBody ContextParcela context) {

		Parcelas parcela = new Parcelas();

		ArrayList<Parcelas> sList = parcela.calcParcelasComJuros(context.getCondicaoPagamento(),
				context.getProduto().getValor());
	
		// Formatando a saída para Json
		JSONArray allDataArray = new JSONArray();
		
		if (!(sList.size() == 0)) {
			for(int index = 0; index < sList.size(); index++) {
				JSONObject eachData = new JSONObject();
				try {
					eachData.put("numeroParcela", sList.get(index).getNumeroParcela());
					eachData.put("valor", sList.get(index).getValor());
					eachData.put("taxaJurosAoMes", sList.get(index).getTaxaJurosAoMes());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				allDataArray.put(eachData);
			}
		}

		JSONObject root = new JSONObject();
		root.put("parcelas", allDataArray);
		    
		return root.toString();
	}
	
}
