# Sortado

## Como instalar

* instale a ferramenta git no seu computador (<https://git-scm.com/downloads>)
* rode o comando `git clone https://github.com/marcossFarias/sortado.git` em um diretório de sua escolha
* instale o editor de código VSCode no seu computador (<https://code.visualstudio.com/Download>)
* abra o diretório onde você clonou o projeto com o VSCode
* instale o pack de extensões "Extension Pack For Java" (<https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack>)

> Esses passos foram testados a risca em uma instalçao limpa do PopOS 22.04

## Como usar

* crie e adicone no diretório [resources/kaggle](resources/kaggle/) os arquivos `pedestrian.cs`
e `road_accidents_czechia_2016_2022.csv` disponíveis em <https://www.kaggle.com/datasets/pereprosov/road-accidents-in-the-czech-republic/download?datasetVersionNumber=3>

* abra o arquivo `Main.java` e execute ele

## Comportamneto

* toda vez que o `Main.java` é executado o código exclui os arquivos dentro de [transformations](resources/transformations/) e [ordinations](resources/ordinations) antes de performar outras operações.
* o código olha os arquivos dentro da pasta [kaggle](resources/kaggle/) > aplica os filtros requisitados > coloca os arquivos resultantes em [transformations](resources/transformations/)
* o código procura pelo arquivo [accidents_NCBMV.csv](resources/transformations/accidents_NCBMV.csv) > gera o pior, o melhor e o caso base (que já é o arquivo em si) > coloca os arquivos em [to_ordinate](resources/ordinations/to_ordinate)
* aplica para cada arquivo em [to_ordinate](resources/ordinations/to_ordinate) todos os algoritmos de ordenação pedidos gerando logs de deputação para que o usuário acompanhe a execução (estes incluem o tempo gasto).

## Modularização

O projeto está usando a arquitetura MVC.

Todos os arquivos gerados pelo código ficam em [resources](resources).

* Os das transformações feitas no dataset da kaggle ficam em [transformations](resources/transformations).
* Os das ordenações, que são baseadas no arquivo resultante da primeira transformação, ficam em [ordinations](resources/ordinations).

## Padronização do código

Todos os códigos, comentários e javadoc estão em inglês e seguem a padronização proposta pelo Google (<https://google.github.io/styleguide/javaguide.html>)¹

¹usando a extensão sonar lint
