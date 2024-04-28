# Sistema Bancario

Esses é um sistema bancário feito com na linguagem java com conceitos de threads e exclusão mútua.
---


## Descrição

Este projeto simula a interação entre diferentes entidades em um sistema bancário, onde clientes vão  realizar compras, as lojas vão receber pagamentos e pagar salários e os funcionários vão receber seus salarios e investir uma parte deles. O uso de threads e locks garante a concorrência e o devido compartilhamento de recursos entre as threads.

## Pré-requisitos e como executar o projeto

1. Você precisa ter o Java JDK 17 ou superior instalado no seu computador.
2. Clone o repositório do projeto ou baixe os arquivos e execute o programa.

## Observações
A Main do projeto java está na classe Banco, portanto a incialização dos objetos das classes estão lá

## Funcionamento do sistema

Este projeto em Java simula um sistema bancário básico com a interação entre clientes, funcionários e lojas.  Aqui temos está um breve resumo de como ele funciona:

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
