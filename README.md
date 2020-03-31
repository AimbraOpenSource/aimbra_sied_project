# aimbra_sied_project
Sistema Integrado de Ensino a Distancia

Para iniciar o sistema localmente em seu server, é preciso definir as propriedades de conexão, localizado no arquivo application.properties.

```
# PostgreSQL
spring.jpa.database-platform = org.hibernate.dialect.PostgreSQL94Dialect
spring.datasource.url=jdbc:postgresql://192.168.88.130:5432/aimbra_sied
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
#
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#
server.port=9001
```
É preciso criar o Banco de Dados na qual será persistido, bem como os Schemas pertinentes ao sistema, que são:

- public
- security
- profile

Agora, basta iniciar o servidor:
