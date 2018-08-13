package com.barath.app.mono;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.concurrent.Callable;

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
    	
        return Mono.justOrEmpty("company");
    }

    public Mono<Integer> createMonoWithIntegerType(){
        return Mono.just(1);
    }

    public Mono<String> combineTwoMonosWithAndOperator(){
        return Mono.empty();
    }


    public Mono<String> handleMonoWithError(){

            return Mono.fromCallable(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    throw  new Exception("throw custom exception");

                }
            }).doOnError( error -> {
                System.out.println("Error occured "+error.getMessage());
            }).doOnNext( element -> {
                System.out.println("Success ");
            });
    }



    private Mono<String>  getFirstMono(){
        return Mono.just("barath");

    }

    private Mono<Void> getSecondMono(){
        return Mono.empty();
    }

    public Flux<String> convertMonoToFlux(){

       return Mono.justOrEmpty("Barath").flux();
    }

}
