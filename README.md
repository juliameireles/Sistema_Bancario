# Sistema Bancario
---

# Descrição

Esses é um sistema bancário feito com na linguagem java com conceitos de threads e exclusão mútua.

## Descrição

Uma descrição mais detalhada do seu projeto, explicando o que ele faz, por que é útil e como funciona. Inclua informações sobre as principais funcionalidades e características.

## Pré-requisitos e como executar o projeto

Você precisa ter o Java JDK 17 ou superior instalado no seu computador.
Clone o repositório do projeto ou baixe os arquivos e execute o programa.

## Observações
A main do projeto java está na classe Banco, portanto a incialização dos objetos das classes estão lá

##Funcionamento do sistema

Claro! Este projeto em Java simula um sistema bancário básico com a interação entre clientes, funcionários e lojas. Aqui está um breve resumo do seu funcionamento:

1. **Clientes**:
   - Cada cliente é representado por uma thread.
   - Eles possuem uma conta bancária com saldo inicial de R$ 1000.
   - Os clientes realizam compras alternando entre lojas, gastando R$ 100 ou R$ 200 em cada compra, até que seu saldo seja esgotado.

2. **Funcionários**:
   - Cada funcionário é representado por uma thread.
   - Eles recebem um salário fixo de R$ 1400.
   - Após receberem o salário, 20% do valor é investido em uma conta de investimento.

3. **Lojas**:
   - Cada loja possui uma conta bancária para receber os pagamentos dos clientes e pagar os salários dos funcionários.
   - As lojas pagam os salários dos funcionários assim que possuem o valor disponível em sua conta.

4. **Controle de Concorrência**:
   - O projeto utiliza locks (`ReentrantLock`) para garantir a exclusão mútua durante operações críticas, como depósitos, saques, pagamento de salários e investimentos.
