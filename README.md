# E-mail sender

Exemplo de envio de e-mail utilizando Spring com o Template processor Thymeleaf.
No projeto é aplicado conceitos do Spring Profiles, para controlar o destinatário do email de acordo com os ambientes definidos.

## Configuração

Properties necessárias:

1. `spring.mail.host` o endereço do email server;
3. `spring.mail.username` usuário da conta remetente, quem vai enviar o e-mail.
4. `spring.mail.password` senha da conta remetente.

### Propriedades customizadas

1. `mpx.email.implementacao` tipo de implementação do envio de email, `testes` voce especifica o destinatário em `mpx.email.teste.destinatario` no arquivo `application.properties` e `producao` especificado em `application-prod.properties`
2. `mpx.email.remetente` mesmo usuário de `spring.mail.username`
3. `mpx.email.teste.destinatario` usuário destinatário de testes


