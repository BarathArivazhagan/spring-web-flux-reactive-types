package com.barath.app;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@Service
public class MonoService {




    public Mono<String> createMonoOfString(){
       return   Mono.just("barath");
    }

    public Mono<String> createMonoOfStringWithDelay(){
        return   Mono.just("barath").delayElement(Duration.ofSeconds(10));
    }


    public Mono<String> createMonoWithOperatorOnNext(){
        return Mono.justOrEmpty("accenture").doOnNext( (name) -> System.out.println("name is "+name));
    }

    public Mono<Integer> createMonoWithIntegerType(){
        return Mono.just(1);
    }

    public Mono<String> combineTwoMonosWithAndOperator(){
        return Mono.empty();
    }




    private Mono<String>  getFirstMono(){
        return Mono.just("barath");

    }

    private Mono<Void> getSecondMono(){
        return Mono.empty();
    }

}
