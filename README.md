CP1 - 2024 - Sem 2
Aluna: Raquel Calmon Tristão Guzansky
RM 97373

Escopo:

Uma biblioteca universitária está procurando modernizar seu sistema de gerenciamento de inventário.
Eles desejam uma aplicação web simples que permita aos funcionários gerenciar o catálogo de livros
da biblioteca de forma eficiente. A aplicação deve permitir operações básicas de CRUD (Create, Read,
Update, Delete) para os livros no catálogo. Além disso, a biblioteca quer oferecer diferentes estratégias
de classificação dos livros para facilitar a busca e organização do inventário.

CRUD de Livros: A aplicação deve permitir aos funcionários adicionar, visualizar, atualizar e remover
livros do catálogo. Cada livro deve ter as seguintes informações:

ID (único)
Título
Autor(es)
Ano de Publicação
Categoria (por exemplo, Ficção, Não-Ficção, Educação, etc.)

Estratégias de Classificação: Implementar o padrão de design Strategy para permitir diferentes
estratégias de classificação dos livros. Por exemplo:
Classificar por título (ordem alfabética)
Classificar por ano de publicação (mais recentes primeiro)
Classificar por categoria
Pesquisa de Livros: A aplicação deve oferecer uma funcionalidade de pesquisa que permita aos usuários buscar livros por título, autor ou categoria.
Utilizar Java com Spring Boot para o backend, configurado com Gradle.
Empregar o banco de dados em memória H2 para persistência dos dados.
Aplicar o padrão de design Strategy para as estratégias de classificação dos livros.
Implementar dois testes de componentes: um para um cenário feliz (por exemplo, adicionar um novo
livro com sucesso) e outro para um cenário de exceção (por exemplo, tentar adicionar um livro com
informações incompletas).
Critérios de aceite
precisa ter dois testes de componente do controller um cenário feliz e outro cenário de excessão.
Precisa ter todas as classes implementadas e funcionando com conexão do banco de dados