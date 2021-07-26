package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import repository.AccountRepository;
import repository.ClientRepository;
import java.sql.SQLException;

@Configuration
@Component
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public ClientRepository clientRepository() throws SQLException {
        return new ClientRepository();
    }

    @Bean
    @Scope("prototype")
    public AccountRepository accountRepository() throws SQLException {
        return new AccountRepository();
    }
}
