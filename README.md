# Desafio-Instagram


Foi criada uma aplicação com o back-end em Spring. Para persistir os dados foi utilizado banco de dados de testes(h2). 
Para gerenciador de dependencias foi utilizado o Maven. Foi utilizado o Swagger para facilitar as operaçoes.

# Executando o projeto

1. Criar um banco no MySql chamado "desafioinstagram". 
Obs.: Está configurado para rodar na porta 8081, caso necessario, alterar no arquivo: application.properties no diretório src/main/resources
2. Rodar a aplicação DesafioInstagramApplication. 
3. Abrir no navegador http://localhost:8081/swagger-ui.html para testar as operações.
4. O projeto está configurado para rodar com um banco de dados de testes (H2), não será necessário criar nenhum outro banco.
5. Foi realizada uma carga inicial de Usuário e conta.
6. Pela regra definida, não é possivel existir um usuário sem uma conta ou vice-versa.

# TODO

1. Repositorio de imagens
2. Implementar JWT
3. Validações
4. Mensagens diretas.
5. "Curtir" Postagens, comentarios e mensagens diretas.
