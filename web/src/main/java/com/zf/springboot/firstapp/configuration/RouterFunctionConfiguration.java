package com.zf.springboot.firstapp.configuration;

import com.zf.springboot.firstapp.domain.User;
import com.zf.springboot.firstapp.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * Created by Administrator on 2018/3/4.
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
//    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){


        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    Collection<User> users = userRepository.findAll();

                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
