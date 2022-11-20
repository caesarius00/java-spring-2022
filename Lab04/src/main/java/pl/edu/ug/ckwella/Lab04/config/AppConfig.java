package pl.edu.ug.ckwella.Lab04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;

public class AppConfig {
    @Bean
    @Scope("prototype")
    public LiturgicalVestment createVestment(){
        System.out.println("Tworzę beana metodą createVestment");
        return new LiturgicalVestment();
    }

}
