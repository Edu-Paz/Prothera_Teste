# Teste Prático - Prothera

Este projeto foi desenvolvido para atender ao teste prático de programação proposto pela Prothera, cobrindo os requisitos de modelagem, manipulação de dados e processamento de funcionários.

## Objetivo

Implementar um sistema em Java para:

- modelar uma pessoa e um funcionário
- inserir, remover e manipular uma lista de funcionários
- formatar datas e valores monetários
- aplicar aumento salarial
- agrupar por função
- identificar aniversariantes
- localizar o funcionário mais velho
- ordenar alfabeticamente
- somar salários
- calcular quantos salários mínimos cada funcionário recebe

## Estrutura do projeto

- `src/entities/Pessoa.java`
- `src/entities/Funcionario.java`
- `src/principal/Principal.java`
- `README.md`

## Requisitos atendidos

### 1. Classe Pessoa
A classe `Pessoa` foi criada com os atributos:

- `nome` (`String`)
- `dataNascimento` (`LocalDate`)

### 2. Classe Funcionário
A classe `Funcionario` estende `Pessoa` e contém:

- `salario` (`BigDecimal`)
- `funcao` (`String`)

### 3. Classe Principal
A classe `Principal` executa as ações do teste:

3.1 - Inserir todos os funcionários na ordem da tabela

3.2 - Remover o funcionário `João`

3.3 - Imprimir todos os funcionários com:
- data em `dd/MM/yyyy`
- salário em formato brasileiro com ponto e vírgula

3.4 - Aplicar aumento de 10% sobre o salário

3.5 - Agrupar funcionários por função em `Map<String, List<Funcionario>>`

3.6 - Imprimir os funcionários agrupados por função

3.8 - Imprimir os funcionários que fazem aniversário nos meses 10 e 12

3.9 - Imprimir o funcionário mais velho, com nome e idade

3.10 - Exibir a lista por ordem alfabética

3.11 - Imprimir o total dos salários dos funcionários

3.12 - Calcular quantos salários mínimos cada funcionário recebe, considerando `R$ 1212,00`

## Decisão sobre `get(0)` em vez de `getFirst()`

Foi utilizada a abordagem `funcionarios.get(0)` em vez de `getFirst()` por questão de compatibilidade.

A operação `getFirst()` foi adicionada ao `List` apenas no Java 21. Como o objetivo foi manter maior compatibilidade com versões mais comuns do Java, como Java 17 e Java 11, a opção `get(0)` foi a mais segura e universal.

Essa decisão evita erros de compilação em ambientes que ainda não utilizam Java 21.

## Padrões utilizados durante o desenvolvimento

### Encapsulamento
Os atributos foram mantidos privados e acessados por `getters` e `setters`.

### Herança
A classe `Funcionario` herda de `Pessoa` e amplia o modelo com atributos específicos.

### `LocalDate`
Foi utilizado para representar datas com precisão, sem hora.

### `BigDecimal`
Foi escolhido para o salário e para cálculos financeiros, evitando problemas de precisão com `double` e `float`.

### `toString()`
A classe `Funcionario` sobrescreveu `toString()` para centralizar a apresentação dos dados com a formatação exigida no teste.

### Streams e `Map`
Foi utilizado `Collectors.groupingBy(...)` para agrupar funcionários por função.

### Ordenação alfabética
Foi utilizado `Comparator.comparing(Funcionario::getNome)` para ordenar a lista por nome.

### Cálculo de idade
A idade foi calculada com `Period.between(...)` e `LocalDate.now(ZoneId.of("America/Sao_Paulo"))` para evitar ambiguidades de timezone e manter precisão.

### Validação simples
Foram incluídas verificações básicas para:

- lista vazia
- nome inválido
- funcionário ou salário nulos

Sem exagerar em tratamento de exceções, mantendo o foco na lógica do teste.

### Constantes para mensagens repetidas
Mensagens repetidas como `Lista vazia.`, `Nome inválido.` e `***FIM***` foram centralizadas em constantes da classe para reduzir duplicação.

## Observações finais

O projeto foi implementado com foco em clareza, organização e aderência ao enunciado. A solução atende aos requisitos do teste prático e foi estruturada em pacotes e métodos que facilitam leitura e manutenção.

A arquitetura aplicada é adequada para o nível do exercício e demonstra domínio em:

- Programação orientada a objetos
- Java Collections
- Datas e tempo
- Moeda com `BigDecimal`
- Ordenação e agrupamento
- Organização de código em Java

Este README foi incluído para documentar a solução e os padrões utilizados durante o desenvolvimento do projeto.
