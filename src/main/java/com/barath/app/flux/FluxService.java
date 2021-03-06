package com.barath.app.flux;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * @author barath
 */
@Service
public class FluxService {




    public Flux<String> createFluxOfStrings(){
        return Flux.just("DHONI","SACHIN","VIRAT");
    }

    public Flux<String> createEmptyFlux(){
        return Flux.empty();
    }


    /**
     * Using Flux.concat function we can combine two fluxes
     *
     *
     *
     * @return an instance of Flux
     */
    public Flux<String>  combineTwoFlux(){

       return Flux.concat(getFirstFlux()).concatWith(getSecondFlux());
    }

    public Flux<String> mergeTwoFlux(){
        return Flux.merge(getFirstFlux()).mergeWith(getSecondFlux());
    }


    public Flux<String> fluxFromIterable(){
        return Flux.fromIterable(Arrays.asList("BARATH","DHONI"));
    }

    public Flux<String> fluxFromArray(){
        return Flux.fromArray( new String[]{"BARATH","DHONI"});
    }

    public Flux<String> handleFluxWithError(){

        return Flux.fromArray( new String[]{"BARATH","DHONI"}).doOnNext( name -> {

            System.out.println("name received "+name);
            if("BARATH".equals(name)){
                throw new RuntimeException("throw custom forced exception");
            }
        }).doOnError( error -> {
            System.out.println("Error occured "+error.getMessage());
        }).onErrorReturn("ERROR BARATH");
    }

    private Flux<String> getFirstFlux(){

        return Flux.just("RAMESH","SURESH","MAHESH");
    }

    private Flux<String> getSecondFlux(){

        return Flux.just("BILL","HAYDEN","SMITH");
    }

    private Flux<String> getSecondFluxWithDuplicateValues(){

        return Flux.just("BILL","HAYDEN","SMITH");
    }
}
