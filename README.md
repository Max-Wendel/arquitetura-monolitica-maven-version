![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=Max-Wendel-UFC_arquitetura-monolitica-maven-version&metric=alert_status)

[![CircleCI](https://circleci.com/gh/Max-Wendel-UFC/arquitetura-monolitica-maven-version/tree/master.svg?style=svg)](https://circleci.com/gh/Max-Wendel-UFC/arquitetura-monolitica-maven-version/tree/master)

# Arquitetura
![alt tag](https://github.com/emmanuelneri/arquitetura-monolitica/blob/master/arquitetura-monolotica.png)

#Requisitos
- Postgres 9.3+
- Wildfly 8.0.2.Final
- Java 8


# Configurando Projeto
1 - Adicionar módulo Postgres no Wildfly
  - Adicionar jar do Posgres em  modules/system/layers/base/org/postgresql
  - Configurar driver no standalone/configuration/standalone.xml
  
  ```
  <datasources>
    <driver name="postgresql" module="org.postgresql">
      <xa-datasource-class>org.postgresql.Driver</xa-datasource-class>
    </driver>
 </datasources>
 ```
 

2 - Configurar DataSource no Wildfly
  - Adicionar nova configuração de datasource
  
  ```
  <datasources>
     <datasource jta="true" jndi-name="java:jboss/datasources/MonoliticaDS" pool-name="MonoliticaDS" enabled="true" use-java-context="true" use-ccm="true">
      <connection-url>jdbc:postgresql://localhost:5432/monolitica</connection-url>
      <driver>postgresql</driver>
      <security>
        <user-name>postgres</user-name>
        <password>postgres</password>
      </security>
    </datasource>
 </datasources>
 ```
 Obs: O Datasource está configurado para acessar a porta padrão do Postgres e como usuário e senha "postgres"
 
3 - Criar o Banco
  - Criar um banco no postgres chamado "monolitica"
  
  
  
# Utilizando Aplicação

1 - Logar no sistema
- email: teste@gmail.com
- senha: 123

 ### Tarefas 
 1. Revisar e configurar o _pom.xml_.
 2. Entender e configurar o ciclo de vida do _maven_.
 3. Implementar uma Integração Continua.
 4. Implementar _Continuous Integration_, _Continuous Delivery_ e _Continuous Deployment_.
 5. Adicionar análises estática de código ao projeto (_Findbugs_ e _Checkstyle_ no caso).
 6. Criar testes unitários com _Junit_ e _Mockito_.
 7. Criar testes sistêmicos com _Jmeter_, em um ambiente de homologação.
 8. Adicionar uma cobertura de código, que deve ser vista por uma ferramenta (cobertura com Jacoco vista com sonarcloud).
 9. Criar um _Dockerfile_ e um _docker-compose_ para a entrega final.
