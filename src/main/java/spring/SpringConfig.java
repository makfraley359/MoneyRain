package spring;

import models.Account;
import models.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public Client client() {
        return new Client();
    }

    @Bean
    @Scope("prototype")
    public Account account() {
        return new Account();
    }
}
