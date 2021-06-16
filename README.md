# Desafio Validação de Senha

## Sobre o desafio
Construir uma aplicação que exponha uma api web que valide se uma senha é válida, seguindo às seguintes regras:
* Nove ou mais caracteres
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial
    * Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto

## Como foi desenvolvido
* O **Core** do projeto foi desenvolvido em Java 11, Spring Boot e Spring Framework.
* Para a **validação da senha**, foi utilizado uma combinação do Pattern Matcher (para validação das regras) e Jackson Annotation (não vazio e não nulo)
* Os **testes** foram realizados com JUnit 5 e Mockito
* **Logs** estão sendo orquestrados pelo slf4j
* Maven para **empacotamento** da solução

## Build e Compile
### IDE
1. Importar o projeto como um projeto maven
2. Buildar a solução com o maven com ```mvn clean install```
3. Executar como ```Java Application```

### CMD
1. Buildar a solução com ```mvn clean install```
2. Executar com ```mvn spring-boot:run```

> Por default, a API será exposta na porta 8080
## Execução
```POST /api/v1/user```
### Body
Envio:
```Json
{
  "password": "Ab123$aw@e"
}
```
Retorno:
```Json
{
  "data": "true"
}
```

Os retornos possíveis são:
* 200 - OK: A API validou a senha com sucesso
* 400 - Bad Request: Campos obrigatórios não foram informados ou o Json recebido está mal formatado
* 500 - Server Error: A API quebrou devido a um erro desconhecido
* 404 - Not Found: O recurso solicitado não foi encontrado
