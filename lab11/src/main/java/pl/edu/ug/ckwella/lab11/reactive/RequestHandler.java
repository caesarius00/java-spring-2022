package pl.edu.ug.ckwella.lab11.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
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

    public Mono<ServerResponse> thicknessFilter(ServerRequest request) {
        Flux<Material> materialFlux = materialService.materialStream()
                .filter(material -> material.getThickness() > 50);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(materialFlux, Material.class);

    }

    //map density
    public Mono<ServerResponse> densityMap(ServerRequest request) {
        Flux<String> materialFlux = materialService.materialStream()
                .map(material -> "Density of " + material.getName() + ": " + material.getDensity());

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(materialFlux, Material.class);

    }

}

