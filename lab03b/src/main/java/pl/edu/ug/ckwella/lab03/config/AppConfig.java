package pl.edu.ug.ckwella.lab03.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.ckwella.lab03.domain.Person;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("object2")
    @Scope("singleton")
    public Person createUsingComponent(){
        return new Person();
    }

    @Bean
    @Scope("prototype")
    public Person createUsingPrototype(){
        return new Person();
    }

}
