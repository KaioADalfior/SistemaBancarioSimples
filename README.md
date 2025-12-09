# SistemaBancarioSimples
Simulador Bancário em Java. Projeto focado em POO e Encapsulamento. Permite gerenciar contas, cadastrar clientes, login, consultar saldo, depositar e sacar via terminal.

Este é um projeto prático desenvolvido como parte do aprofundamento em Java e Programação Orientada a Objetos (POO). O objetivo é simular um sistema bancário básico de console (terminal), aplicando os conceitos de modularização, encapsulamento e manipulação de coleções.

O projeto foi construído puramente em Java Standard Edition (SE) e foca nos seguintes fundamentos:

Programação Orientada a Objetos (POO): Uso de classes, objetos e métodos para representar entidades do mundo real (Contas e o Banco).
Encapsulamento: Utilização de atributos private (como `saldo` e `cpf`) e métodos public (Getters, `depositar`, `sacar`) para proteger e controlar o acesso aos dados.
Collections (List):Uso de `ArrayList` na classe `Banco` para armazenar e gerenciar dinamicamente múltiplos objetos `ContaBancaria`.
Controle de Fluxo e Loops: Uso de `while` para manter o menu principal em execução e `switch/case` para navegação.
Input/Output (I/O):Interação com o usuário via terminal usando a classe Scanner.

---

Arquitetura do Projeto:

O sistema é dividido em três classes principais, seguindo o princípio de responsabilidade única:

| Classe | Responsabilidade Principal |
| :--- | :--- |
| App.java| Controlador: Contém o método `main`, exibe os menus (principal e operações) e gerencia a interação do usuário. |
| Banco.java | Gerenciador de Dados:Armazena e administra a lista de todas as contas. Implementa a lógica de cadastrarConta e buscarConta. |
| ContaBancaria.java | Modelo de Dados: Representa o objeto de uma conta individual (Titular, Saldo, Número). Implementa a lógica de `depositar` e `sacar`. |

---

Funcionalidades: 

O usuário pode interagir com o sistema através do console para executar as seguintes operações:

1.  Cadastrar Novo Cliente: Adiciona uma nova `ContaBancaria` à lista do `Banco`.
   
2.  Acessar Conta Existente (Login):** Busca e autentica a conta pelo número.
  
3.  Operações (Sub-Menu): Após o login, permite:
   -> Consultar Saldo.
   ->  ealizar Depósito.
   -> Realizar Saque (com verificação de saldo insuficiente).
    
4.  Listar Todos os Clientes: Exibe um relatório simples de todas as contas cadastradas.




