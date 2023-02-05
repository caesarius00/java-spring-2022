package pl.edu.ug.ckwella.Lab04.reactive;

import org.springframework.stereotype.Service;
import pl.edu.ug.ckwella.Lab04.domain.Material;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class MaterialService {

    public Flux<Material> materialStream() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

        Random random = new Random();

        Flux<Material> events = Flux.fromStream(Stream.generate(() -> new Material(
                "RandomMaterial" + random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100)
        )));

        return Flux.zip(events, interval, (e, i) -> e);

    }
}
