package pl.edu.ug.ckwella.lab03.zad2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.ckwella.lab03.domain.Person;

@Configuration
public class Config {

    @Bean
    @Qualifier("prezes")
    @Scope("singleton")
    public Person createPrezes(){
        return new Person("Chrystal", "Havoc", "chavocr@yahoo.com" , "Mymm");
    }

    @Bean
    @Qualifier("wiceprezes")
    @Scope("singleton")
    public Person createWiceprezes(){
        return new Person("Halley","Gadaud", "hgadaud9@sohu.com", "Oyope");
    }

    @Bean
    @Qualifier("serkretarka")
    @Scope("singleton")
    public Person createSekretarka(){
        return new Person("Kirbie", "Wrettum", "kwrettumj@slideshare.net", "Browsetype");
    }
}
