# api-calculoDeJuros

**Teste de back-end Via Varejo**

Este teste busca avaliar quesitos técnicos para as pessoas que se candidatem às vagas de desenvolvimento back-end da Via Varejo.

**O desafio**
Seu objetivo é criar um endpoint para que possamos simular a compra de um produto, deve retornar uma lista de parcelas,
acrescidas de juros com base na taxa SELIC de 1.15% ao mês (se possível consultar a taxa em tempo real), 
somente quando o número de parcelas for superior a 06 (seis) parcelas.


**Para executar o programa:**

- Baixe o codigo fonte disponibilizado no git com o comando Git Clone <nome do repositorio>
- Abra a IDE java Eclipse e import o projeto selecionando a opção maven project.
- Execute o programa clicando em Run aplication.

**Para testar o servico faça:**

Baixe e instale o programa POSTMAN no link baixo:
https://www.getpostman.com/downloads/

Com o programa aberto selecione o verbo Http POST.
Na mesma linha coloque a URL do servico/API para este serviço especifico: http://localhost:8080/calculoDeJuros

Para melhor visualização ajuste o Body para Raw e o tipo de visualização para JSON(application/json)

Digite abaixo a entrada esperada pelo serviço:

{
	"produto": {
        "codigo": 123,
        "nome": "Nome do Produto",
        "valor": 200.00
    },
    "condicaoPagamento": {
        "valorEntrada": 50.00,
        "qtdeParcelas": 8
    }
}

O programa apresenta a saida esperada.
