# Sortado

## Como instalar

* instale a ferramenta git no seu computador (<https://git-scm.com/downloads>)
* rode o comando `git clone xxxxxx` em um diretório de sua escolha
* instale o editor de código VSCode no seu computador (<https://code.visualstudio.com/Download>)
* abra o diretório onde você clonou o projeto com o VSCode

## Como usar

* crie e adicone no diretório [resources/kaggle](resources/kaggle/) os arquivos `pedestrian.cs`
e `road_accidents_czechia_2016_2022.csv` disponíveis em <https://www.kaggle.com/datasets/pereprosov/road-accidents-in-the-czech-republic/download?datasetVersionNumber=3>

* abra o arquivo `Main.java` e execute ele

## Comportamneto

* toda vez que o `Main.java` é executado o código exclui os arquivos dentro de transformations e ordinations antes de performar outras operações.

## Modularização

O projeto está usando a arquitetura MVC.

Todos os arquivos gerados pelo código ficam em [resources](resources).

* Os das transformações feitas no dataset da kaggle ficam em [transformations](resources/transformations).
* Os das ordenações, que são baseadas no arquivo resultante da primeira transformação, ficam em [ordinations](resources/ordinations).

## Padronização do código

Todos os códigos, comentários e javadoc estão em inglês e seguem a padronização proposta pelo Google (<https://google.github.io/styleguide/javaguide.html>)¹

¹usando a extensão sonar lint
