package pl.edu.ug.ckwella.lab11.reactive;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RequestRouter {

    @Bean
    RouterFunction<?> routes(RequestHandler requestHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/material"), requestHandler::materialStream)
                .andRoute(RequestPredicates.GET("/material/thickness"), requestHandler::thicknessFilter)
                .andRoute(RequestPredicates.GET("/material/density"), requestHandler::densityMap);
    }

}
