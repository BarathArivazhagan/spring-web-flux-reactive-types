package com.barath.app;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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


    private Flux<String> getFirstFlux(){

        return Flux.just("RAMESH,SURESH,MAHESH");
    }

    private Flux<String> getSecondFlux(){

        return Flux.just("BILL,HAYDEN,SMITH");
    }
}
