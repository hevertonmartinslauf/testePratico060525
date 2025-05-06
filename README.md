APLICAÇÃO JAVA DESKTOP UTILIZANDO JAVA SWING PARA DESENVOLVIMENTO DAS INTERFACES GRÁFICAS

UTILIZEI O PADRÃO MVC COMO PADRONIZAÇÃO DO PROJETO

A aplicação desenvolvida tem as seguintes funcionalidades:

TELA LOGIN(login do usuário com validação no banco de dados). Para o primeiro acesso, o usuário deverá acessar a tela SIGNUP e efetuar o cadastro.
  -> validação de dados e acesso ao sistema

TELA SIGNUP(cadastro de novo usuário e persistência no banco de dados)
   -> validação de campos e a utilização do algoritmo SHA256 para criptografar as senhas salvas no banco de dados
   -> tratamento de exception referente a não permissão de cadastrar dois usuários com mesmo e-mail.

TELA CADASTRO DE FUNCIONÁRIOS
  -> validação de campos e CRUD com persistência no banco de dados.
  -> utilização de JTable para visualização dos funcionários cadastrados

Tratamento adequado de exceções diversas: banco de dados, unique e-mail etc

Configuração do Projeto nas IDE:

Por ser um projeto Java, o processo de configuração dele é padrão de qualquer projeto Java.
