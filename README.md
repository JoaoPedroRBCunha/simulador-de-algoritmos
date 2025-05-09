# Simulador de algoritmos de substituição de páginas

## Introdução
Este projeto foi desenvolvido como parte da disciplina <strong>Projeto de Sistemas Operacionais</strong>,
focado em algoritmos de substituição de página.

## Objetivo
Simulador para os principais algoritmos de substituição de páginas (Aging, FIFO (com bit de referência), LRU e NFU), 
com o objetivo de verificar as faltas de páginas no gerenciamento da memória virtual.

## Para executar

Para compliar o projeto:
``` 
javac -d out src/**/*.java
```
Para executar o programa:
``` 
java -cp out Main
```

## Exemplo e resultado
```
Simulador de algoritmos de substituição de páginas
Informe o tamanho da memória (capacidade de frames):
3
Informe o tamanho da string de referência:
12
Informe se deseja fazer inserção aleatória na string de referência? (S/N):
N
Informe o valor da página para a posição 1˚ (número inteiro): 1
Informe o valor da página para a posição 2˚ (número inteiro): 2
Informe o valor da página para a posição 3˚ (número inteiro): 3
Informe o valor da página para a posição 4˚ (número inteiro): 2
Informe o valor da página para a posição 5˚ (número inteiro): 1
Informe o valor da página para a posição 6˚ (número inteiro): 4
Informe o valor da página para a posição 7˚ (número inteiro): 5
Informe o valor da página para a posição 8˚ (número inteiro): 2
Informe o valor da página para a posição 9˚ (número inteiro): 1
Informe o valor da página para a posição 10˚ (número inteiro): 2
Informe o valor da página para a posição 11˚ (número inteiro): 3
Informe o valor da página para a posição 12˚ (número inteiro): 4
String de referência gerada: [1, 2, 3, 2, 1, 4, 5, 2, 1, 2, 3, 4]

ALGORITMO FIFO: 
Falhas de página: 9
Acessos de página: 3
Taxa de acesso: 25,00%
Taxa de falhas de página: 75,00%
==================================================
ALGORITMO LRU COM BIT DE REFERÊNCIA
Falhas de página: 9
Acessos de página: 3
Taxa de acesso: 25,00%
Taxa de falhas de página: 75,00%
==================================================
ALGORITMO NFU
Falhas de página: 7
Acessos de página: 5
Taxa de acesso: 41,67%
Taxa de falhas de página: 58,33%
==================================================
ALGORITMO AGING
Falhas de página: 9
Acessos de página: 3
Taxa de acesso: 25,00%
Taxa de falhas de página: 75,00%
==================================================
```

## Autores:

* ```Nome: João Pedro Ribeiro Cunha```
```Matrícula: 2315090```

* ```Nome: Raul Belém Pontes```
```Matrícula: 2316706```

* ```Nome: Máximo Henrique Neto```
```Matrícula: 2315057```
