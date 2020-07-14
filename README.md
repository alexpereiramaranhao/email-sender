# E-mail sender

Example of sending email using Spring Profiles, to, in progress, not forward a message to the real customer, but to a test address.

## Configuration

To provide greater security, the variables:

1. spring.mail.host
2. spring.mail.properties.mail.smtp.ssl.trust
3. spring.mail.username
4. spring.mail.password

They are declared in environment variables, following the Spring pattern: `spring.mail.host`, fica `SPRING_MAIL_HOST`


