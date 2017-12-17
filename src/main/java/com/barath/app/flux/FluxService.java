package com.barath.app.flux;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * Created by barath.arivazhagan on 9/5/2017.
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
