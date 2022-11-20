package pl.edu.ug.ckwella.lab03.zad2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.ug.ckwella.lab03.domain.Person;

@Component
public class Service {
    private final Person person1;
    private final Person person2;
    private final Person person3;

    public Service(@Autowired @Qualifier("prezes") Person person1, @Autowired @Qualifier("wiceprezes") Person person2, @Autowired @Qualifier("serkretarka") Person person3) {
        this.person1 = person1;
        this.person2 = person2;
        this.person3 = person3;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public Person getPerson3() {
        return person3;
    }
}
