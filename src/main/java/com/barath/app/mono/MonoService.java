package com.barath.app.mono;


import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author barath
 */
@Service
public class MonoService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
                logger.error("Error occured {}",error.getMessage());
            }).doOnNext( element -> {
                logger.info("Success ");
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
