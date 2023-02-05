package pl.edu.ug.ckwella.Lab04.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.edu.ug.ckwella.Lab04.domain.Material;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler {

    private final MaterialService materialService;

    public RequestHandler(MaterialService materialService) {
        this.materialService = materialService;
    }

    public Mono<ServerResponse> materialStream(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(materialService.materialStream(), Material.class);

    }
}

